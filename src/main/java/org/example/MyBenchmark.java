/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package org.example;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MyBenchmark {

    /*static Random r = new Random(Calendar.getInstance().getTimeInMillis());

    @State(Scope.Thread)
    public static class Array {

        @Setup(Level.Invocation)
        public void doSetup() {
            for (int i = 0; i < 100000; i++) {
                elements[i] = r.nextInt(30000);
            }
        }

        public int[] elements = new int[100000];
    }*/

    @Benchmark @Fork(1) @BenchmarkMode(Mode.AverageTime) @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void testMethod() {
        // place your benchmarked code here
        // Arrays.sort(a.elements);
        int[] numbers = new int[] {9, 5, 2, 23, 8, 4, 345, 3, 4523, 54 ,2};
        Arrays.sort(numbers);
        MyFunctions.calcPrimesNumber1(1000000);
    }
}
