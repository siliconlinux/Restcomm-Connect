/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2014, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 */
package org.restcomm.connect.telephony.api;

import akka.actor.ActorRef;

import org.restcomm.connect.commons.annotations.concurrency.Immutable;
import org.restcomm.connect.dao.entities.MediaAttributes;

/**
 * @author quintana.thomas@gmail.com (Thomas Quintana)
 */
@Immutable
public final class AddParticipant {
    private final ActorRef call;
    private final MediaAttributes mediaAttributes;

    public AddParticipant(final ActorRef call) {
        this(call, new MediaAttributes());
    }

    public AddParticipant(final ActorRef call, final MediaAttributes mediaAttributes){
        super();
        this.call = call;
        this.mediaAttributes = mediaAttributes;
    }

    public ActorRef call() {
        return call;
    }

    public MediaAttributes mediaAttributes(){
        return mediaAttributes;
    }
}
