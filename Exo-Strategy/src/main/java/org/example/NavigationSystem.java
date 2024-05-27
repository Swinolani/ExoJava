package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NavigationSystem {

    private String destination;

    public void startNavigation(StrategiesNavigation typeDeNavigation) {
        typeDeNavigation.navigate(destination);
    }
}
