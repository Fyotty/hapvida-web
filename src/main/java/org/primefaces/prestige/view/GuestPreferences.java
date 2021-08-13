package org.primefaces.prestige.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named
@SessionScoped
public class GuestPreferences implements Serializable {

    private String menuMode = "layout-menu-horizontal";

    private String theme = "deepblue-light";

    private String layout = "layout-canvas";

    private List<ComponentTheme> componentThemes = new ArrayList<ComponentTheme>();

    private List<LayoutTheme> layoutThemes = new ArrayList<LayoutTheme>();
    
    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getMenuMode() {
        return this.menuMode;
    }

    public void setMenuMode(String menuMode) {
        this.menuMode = menuMode;
    }

    public List<ComponentTheme> getComponentThemes() {
        return componentThemes;
    }

    public List<LayoutTheme> getLayoutThemes() {
        return layoutThemes;
    }

    public void changeLayoutTheme(LayoutTheme layoutTheme) {
        this.layout = layoutTheme.getFile();
        this.theme = layoutTheme.getComponentTheme();
    }

    @PostConstruct
    public void init() {
        componentThemes.add(new ComponentTheme("Amber Accent", "amber-accent", "amber-accent.svg"));
        componentThemes.add(new ComponentTheme("Amber Light", "amber-light", "amber-light.svg"));
        componentThemes.add(new ComponentTheme("Amber Dark", "amber-dark", "amber-dark.svg"));
        componentThemes.add(new ComponentTheme("Blue Accent", "blue-accent", "blue-accent.svg"));
        componentThemes.add(new ComponentTheme("Blue Light", "blue-light", "blue-light.svg"));
        componentThemes.add(new ComponentTheme("Blue Dark", "blue-dark", "blue-dark.svg"));
        componentThemes.add(new ComponentTheme("Blue Gray Accent", "bluegray-accent", "bluegray-accent.svg"));
        componentThemes.add(new ComponentTheme("Blue Gray Light", "bluegray-light", "bluegray-light.svg"));
        componentThemes.add(new ComponentTheme("Blue Gray Dark", "bluegray-dark", "bluegray-dark.svg"));
        componentThemes.add(new ComponentTheme("Brown Accent", "brown-accent", "brown-accent.svg"));
        componentThemes.add(new ComponentTheme("Brown Light", "brown-light", "brown-light.svg"));
        componentThemes.add(new ComponentTheme("Brown Dark", "brown-dark", "brown-dark.svg"));
        componentThemes.add(new ComponentTheme("Cyan Accent", "cyan-accent", "cyan-accent.svg"));
        componentThemes.add(new ComponentTheme("Cyan Light", "cyan-light", "cyan-light.svg"));
        componentThemes.add(new ComponentTheme("Cyan Dark", "cyan-dark", "cyan-dark.svg"));
        componentThemes.add(new ComponentTheme("Deep Orange Accent", "deeporange-accent", "deeporange-accent.svg"));
        componentThemes.add(new ComponentTheme("Deep Orange Light", "deeporange-light", "deeporange-light.svg"));
        componentThemes.add(new ComponentTheme("Deep Orange Dark", "deeporange-dark", "deeporange-dark.svg"));
        componentThemes.add(new ComponentTheme("Gray Accent", "gray-accent", "gray-accent.svg"));
        componentThemes.add(new ComponentTheme("Gray Light", "gray-light", "gray-light.svg"));
        componentThemes.add(new ComponentTheme("Gray Dark", "gray-dark", "gray-dark.svg"));
        componentThemes.add(new ComponentTheme("Green Accent", "green-accent", "green-accent.svg"));
        componentThemes.add(new ComponentTheme("Green Light", "green-light", "green-light.svg"));
        componentThemes.add(new ComponentTheme("Green Dark", "green-dark", "green-dark.svg"));
        componentThemes.add(new ComponentTheme("Indigo Accent", "indigo-accent", "indigo-accent.svg"));
        componentThemes.add(new ComponentTheme("Indigo Light", "indigo-light", "indigo-light.svg"));
        componentThemes.add(new ComponentTheme("Indigo Dark", "indigo-dark", "indigo-dark.svg"));
        componentThemes.add(new ComponentTheme("Lime Accent", "lime-accent", "lime-accent.svg"));
        componentThemes.add(new ComponentTheme("Lime Light", "lime-light", "lime-light.svg"));
        componentThemes.add(new ComponentTheme("Lime Dark", "lime-dark", "lime-dark.svg"));
        componentThemes.add(new ComponentTheme("Pink Accent", "pink-accent", "pink-accent.svg"));
        componentThemes.add(new ComponentTheme("Pink Light", "pink-light", "pink-light.svg"));
        componentThemes.add(new ComponentTheme("Pink Dark", "pink-dark", "pink-dark.svg"));
        componentThemes.add(new ComponentTheme("Deep Blue Accent", "deepblue-accent", "deepblue-accent.svg"));
        componentThemes.add(new ComponentTheme("Deep Blue Light", "deepblue-light", "deepblue-light.svg"));
        componentThemes.add(new ComponentTheme("Deep Blue Dark", "deepblue-dark", "deepblue-dark.svg"));
        componentThemes.add(new ComponentTheme("Deep Purple Accent", "deeppurple-accent", "deeppurple-accent.svg"));
        componentThemes.add(new ComponentTheme("Deep Purple Light", "deeppurple-light", "deeppurple-light.svg"));
        componentThemes.add(new ComponentTheme("Deep Purple Dark", "deeppurple-dark", "deeppurple-dark.svg"));
        componentThemes.add(new ComponentTheme("Teal Accent", "teal-accent", "teal-accent.svg"));
        componentThemes.add(new ComponentTheme("Teal Light", "teal-light", "teal-light.svg"));
        componentThemes.add(new ComponentTheme("Teal Dark", "teal-dark", "teal-dark.svg"));
        componentThemes.add(new ComponentTheme("Purple Accent", "purple-accent", "purple-accent.svg"));
        componentThemes.add(new ComponentTheme("Purple Light", "purple-light", "purple-light.svg"));
        componentThemes.add(new ComponentTheme("Purple Dark", "purple-dark", "purple-dark.svg"));
        componentThemes.add(new ComponentTheme("Turquoise Accent", "turquoise-accent", "turquoise-accent.svg"));
        componentThemes.add(new ComponentTheme("Turquoise Light", "turquoise-light", "turquoise-light.svg"));
        componentThemes.add(new ComponentTheme("Turquoise Dark", "turquoise-dark", "turquoise-dark.svg"));

        layoutThemes.add(new LayoutTheme("Aloe", "layout-aloe", "aloe.png", "turquoise-accent"));
        layoutThemes.add(new LayoutTheme("Aqua", "layout-aqua", "aqua.png", "cyan-dark"));
        layoutThemes.add(new LayoutTheme("Bangkok", "layout-bangkok", "bangkok.png", "turquoise-accent"));
        layoutThemes.add(new LayoutTheme("Canvas", "layout-canvas", "canvas.png", "deepblue-light"));
        layoutThemes.add(new LayoutTheme("Cross", "layout-cross", "cross.png", "purple-dark"));
        layoutThemes.add(new LayoutTheme("Dream", "layout-dream", "dream.png", "teal-light"));
        layoutThemes.add(new LayoutTheme("Emerald", "layout-emerald", "emerald.png", "teal-light"));
        layoutThemes.add(new LayoutTheme("Focus", "layout-focus", "focus.png", "turquoise-dark"));
        layoutThemes.add(new LayoutTheme("Forest", "layout-forest", "forest.png", "turquoise-light"));
        layoutThemes.add(new LayoutTheme("Fractal", "layout-fractal", "fractal.png", "teal-dark"));
        layoutThemes.add(new LayoutTheme("Gem", "layout-gem", "gem.png", "amber-accent"));
        layoutThemes.add(new LayoutTheme("Green", "layout-green", "green.png", "green-light"));
        layoutThemes.add(new LayoutTheme("Indigo", "layout-indigo", "indigo.png", "indigo-light"));
        layoutThemes.add(new LayoutTheme("Joshua", "layout-joshua", "joshua.png", "pink-dark"));
        layoutThemes.add(new LayoutTheme("Laser", "layout-laser", "laser.png", "indigo-light"));
        layoutThemes.add(new LayoutTheme("Lime", "layout-lime", "lime.png", "lime-dark"));
        layoutThemes.add(new LayoutTheme("Maze", "layout-maze", "maze.png", "deeporange-dark"));
        layoutThemes.add(new LayoutTheme("Metro", "layout-metro", "metro.png", "gray-light"));
        layoutThemes.add(new LayoutTheme("Milan", "layout-milan", "milan.png", "gray-dark"));
        layoutThemes.add(new LayoutTheme("Night", "layout-night", "night.png", "bluegray-light"));
        layoutThemes.add(new LayoutTheme("Osterreich", "layout-osterreich", "osterreich.png", "cyan-light"));
        layoutThemes.add(new LayoutTheme("Palm", "layout-palm", "palm.png", "teal-dark"));
        layoutThemes.add(new LayoutTheme("Deep Purple", "layout-deeppurple", "deeppurple.png", "deeppurple-light"));
        layoutThemes.add(new LayoutTheme("Petroleum", "layout-petroleum", "petroleum.png", "gray-accent"));
        layoutThemes.add(new LayoutTheme("Rose", "layout-rose", "rose.png", "pink-light"));
        layoutThemes.add(new LayoutTheme("Sand", "layout-sand", "sand.png", "brown-dark"));
        layoutThemes.add(new LayoutTheme("Steel", "layout-steel", "steel.png", "blue-light"));
        layoutThemes.add(new LayoutTheme("Summer", "layout-summer", "summer.png", "teal-accent"));
        layoutThemes.add(new LayoutTheme("Turquoise", "layout-turquoise", "turquoise.png", "turquoise-accent"));
        layoutThemes.add(new LayoutTheme("Urban", "layout-urban", "urban.png", "deepblue-accent"));
        layoutThemes.add(new LayoutTheme("Madrid", "layout-madrid", "madrid.png", "turquoise-accent"));
        layoutThemes.add(new LayoutTheme("Jungfraujoch", "layout-jungfraujoch", "jungfraujoch.png", "deepblue-light"));
        layoutThemes.add(new LayoutTheme("Polygon", "layout-polygon", "polygon.png", "turquoise-light"));
        layoutThemes.add(new LayoutTheme("Arecaceae", "layout-arecaceae", "arecaceae.png", "lime-accent"));
        layoutThemes.add(new LayoutTheme("MacKenzie", "layout-mackenzie", "mackenzie.png", "lime-dark"));
        layoutThemes.add(new LayoutTheme("Mist", "layout-mist", "mist.png", "lime-dark"));
    }

    public class ComponentTheme {
        String name;
        String file;
        String image;

        public ComponentTheme(String name, String file, String image) {
            this.name = name;
            this.file = file;
            this.image = image;
        }

        public String getName() {
            return this.name;
        }

        public String getFile() {
            return this.file;
        }

        public String getImage() {
            return this.image;
        }
    }

    public class LayoutTheme {
        String name;
        String file;
        String image;
        String componentTheme;

        public LayoutTheme(String name, String file, String image, String componentTheme) {
            this.name = name;
            this.file = file;
            this.image = image;
            this.componentTheme = componentTheme;
        }

        public String getName() {
            return this.name;
        }

        public String getFile() {
            return this.file;
        }

        public String getImage() {
            return this.image;
        }

        public String getComponentTheme() {
            return this.componentTheme;
        }
    }
}
