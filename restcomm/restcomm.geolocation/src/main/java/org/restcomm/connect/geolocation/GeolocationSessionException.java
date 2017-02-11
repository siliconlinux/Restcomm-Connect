/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.restcomm.connect.geolocation;

/**
 * @author quintana.thomas@gmail.com (Thomas Quintana)
 * @author <a href="mailto:fernando.mendioroz@telestax.com"> Fernando Mendioroz </a>
 *
 */
public final class GeolocationSessionException extends Exception {

    /*****************************************************/
    /*** Phase II: internetworking with GMLC through SIP */
    /*****************************************************/
    private static final long serialVersionUID = 1L;

    public GeolocationSessionException(final String message) {
        super(message);
    }

    public GeolocationSessionException(final Throwable cause) {
        super(cause);
    }

    public GeolocationSessionException(final String message, final Throwable cause) {
        super(message, cause);
    }
}