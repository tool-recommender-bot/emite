/*
 * ((e)) emite: A pure Google Web Toolkit XMPP library
 * Copyright (c) 2008-2011 The Emite development team
 * 
 * This file is part of Emite.
 *
 * Emite is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 *
 * Emite is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with Emite.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.calclab.emite.xtesting.handlers;

import com.calclab.emite.core.events.ChangedEvent.ChangeType;
import com.calclab.emite.im.chat.Chat;
import com.calclab.emite.im.events.PairChatChangedEvent;

public class PairChatChangedTestHandler extends TestHandler<PairChatChangedEvent> implements PairChatChangedEvent.Handler {

	private final ChangeType type;

	public PairChatChangedTestHandler() {
		this(null);
	}

	public PairChatChangedTestHandler(final ChangeType type) {
		this.type = type;
	}

	public Chat getLastChat() {
		return hasEvent() ? getLastEvent().getChat() : null;
	}

	@Override
	public void onPairChatChanged(final PairChatChangedEvent event) {
		if (type == null || type.equals(event.getChangeType())) {
			addEvent(event);
		}
	}

}
