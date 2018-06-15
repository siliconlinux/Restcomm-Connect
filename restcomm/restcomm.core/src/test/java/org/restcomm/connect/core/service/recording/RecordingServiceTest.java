/*
 *  TeleStax, Open Source Cloud Communications
 *  Copyright 2011-2018, Telestax Inc and individual contributors
 *  by the @authors tag.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  under the terms of the GNU Affero General Public License as
 *  published by the Free Software Foundation; either version 3 of
 *  the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package org.restcomm.connect.core.service.recording;

import org.junit.Test;
import org.restcomm.connect.commons.amazonS3.S3AccessTool;
import org.restcomm.connect.commons.dao.Sid;
import org.restcomm.connect.dao.RecordingsDao;
import org.restcomm.connect.dao.entities.Recording;

import java.io.File;
import java.io.IOException;
import java.net.URI;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RecordingServiceTest {

    RecordingsDao recordingsDao = mock(RecordingsDao.class);
    S3AccessTool s3AccessTool = mock(S3AccessTool.class);

    Sid recordingSid = Sid.generate(Sid.Type.RECORDING);
    URI s3Uri = URI.create("https://127.0.0.1:8099/s3/dfsdfsaad");

    @Test
    public void deleteRecordingS3Test() throws IOException {
        Recording recording = prepareRecording(recordingSid, true);

        when(recordingsDao.getRecording(recordingSid)).thenReturn(recording);

        RecordingsServiceImpl recordingsService = new RecordingsServiceImpl(recordingsDao, s3AccessTool, null);
        recordingsService.removeRecording(recordingSid);

        verify(s3AccessTool).removeS3Uri(s3Uri);
        verify(recordingsDao).removeRecording(recordingSid);
    }

    @Test
    public void deleteRecordingLocalTest() throws IOException {
        Recording recording = prepareRecording(recordingSid, false);
        File recordingFile = prepareRecordingFile(recordingSid);

        assertTrue(recordingFile.exists());
        assertTrue(recordingFile.isAbsolute());

        when(recordingsDao.getRecording(recordingSid)).thenReturn(recording);

        RecordingsServiceImpl recordingsService = new RecordingsServiceImpl(recordingsDao, s3AccessTool, "file:///"+recordingFile.getParent());
        recordingsService.removeRecording(recordingSid);

        verify(recordingsDao).removeRecording(recordingSid);

        assertTrue(!recordingFile.exists());
    }

    private Recording prepareRecording(Sid recordingSid, boolean s3) {
        Recording.Builder builder = Recording.builder();
        builder.setAccountSid(Sid.generate(Sid.Type.ACCOUNT));
        builder.setSid(recordingSid);
        builder.setApiVersion("2012-04-24");
        builder.setCallSid(new Sid("CA00000000000000000000000000000011"));
        builder.setDuration(20.00);
        builder.setFileUri(URI.create("http://127.0.0.1:8080/restcomm/"+recordingSid+".wav"));
        if (s3)
            builder.setS3Uri(s3Uri);

        return builder.build();
    }

    private File prepareRecordingFile(Sid recordingSid) throws IOException {
        File recordingFile = new File(recordingSid+".wav");
        recordingFile.createNewFile();
        return recordingFile.getAbsoluteFile();
    }

}
