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

package org.restcomm.connect.http;

import static javax.ws.rs.core.MediaType.*;
import static org.restcomm.connect.http.security.AccountPrincipal.SUPER_ADMIN_ROLE;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.restcomm.connect.commons.annotations.concurrency.ThreadSafe;

/**
 * @author <a href="mailto:gvagenas@gmail.com">gvagenas</a>
 *
 */
@Path("/Accounts/{accountSid}/OutboundProxy")
@ThreadSafe
@RolesAllowed(SUPER_ADMIN_ROLE)
public class OutboundProxyXmlEndpoint extends OutboundProxyEndpoint {
    public OutboundProxyXmlEndpoint() {
        super();
    }

    @GET
    public Response getProxies(@PathParam("accountSid") final String accountSid) {
        return getProxies(accountSid, MediaType.valueOf(accept));
    }

    @GET
    @Path("/switchProxy")
    public Response switchProxy(@PathParam("accountSid") final String accountSid) {
        return switchProxy(accountSid, MediaType.valueOf(accept));
    }

    @GET
    @Path("/getActiveProxy")
    public Response getActiveProxy(@PathParam("accountSid") final String accountSid) {
        return getActiveProxy(accountSid, MediaType.valueOf(accept));
    }
}
