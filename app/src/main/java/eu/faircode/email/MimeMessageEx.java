package eu.faircode.email;

/*
    This file is part of Safe email.

    Safe email is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    NetGuard is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with NetGuard.  If not, see <http://www.gnu.org/licenses/>.

    Copyright 2018 by Marcel Bokhorst (M66B)
*/

import android.util.Log;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

public class MimeMessageEx extends MimeMessage {
    private String msgid;

    public MimeMessageEx(Session session, String msgid) {
        super(session);
        this.msgid = msgid;
    }

    @Override
    protected void updateMessageID() throws MessagingException {
        if (msgid == null)
            super.updateMessageID();
        else {
            setHeader("Message-ID", msgid);
            Log.v(Helper.TAG, "Override Message-ID=" + msgid);
        }
    }
}