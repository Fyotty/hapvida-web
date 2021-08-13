/*
 * Copyright 2009-2019 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.prestige.domain;

public enum RoomCategory {

    STANDARD("Standard"),
    SUPERIOR("Superior"),
    DELUXE("Deluxe"),
    JUNIOR("Junior"),
    EXECUTIVE_SUITE("Executive Suite");

    private final String label;

    private RoomCategory(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
