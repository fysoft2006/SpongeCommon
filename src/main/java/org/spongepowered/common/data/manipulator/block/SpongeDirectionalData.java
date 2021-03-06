/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.common.data.manipulator.block;

import static org.spongepowered.api.data.DataQuery.of;

import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.manipulator.block.DirectionalData;
import org.spongepowered.api.util.Direction;
import org.spongepowered.common.data.manipulator.AbstractSingleValueData;

public class SpongeDirectionalData extends AbstractSingleValueData<Direction, DirectionalData> implements DirectionalData {

    public static final DataQuery DIRECTION = of("Direction");

    public SpongeDirectionalData() {
        super(DirectionalData.class, Direction.NONE);
    }

    @Override
    public DirectionalData copy() {
        return new SpongeDirectionalData().setValue(this.getValue());
    }

    @Override
    public int compareTo(DirectionalData o) {
        return o.getValue().ordinal() - this.getValue().ordinal();
    }

    @Override
    public DataContainer toContainer() {
        return new MemoryDataContainer().set(DIRECTION, this.getValue().name());
    }
}
