package com.sirenian.hellbound.events;

import org.jbehave.core.story.domain.World;

public class ThePlayerPressesLeftRotate extends HellboundEvent {

    protected void occurAnyTimeIn(World world) {
        pressKey('x', world);
    }

}