package projectjourney;

import java.awt.Color;

public class Tile {

    private static final Color DEFAULTCOLOR1 = new Color(0, 0, 0);
    private static final Color DEFAULTCOLOR2 = new Color(0, 0, 0);
    private static final Color DARKGREEN = new Color(0, 128, 0);
    
    public static final Enterable enterableGlacier = new Enterable() {
                    public boolean canEnter(Player p) {
                        return true;
                    }
                    public void enter(Player p) {
                        p.getNarrator().getTime().addMinute(10);
                    }
                };
    //public static final Enterable enterableFrozenOcean;       //Has to be defined by each frozenOcean tile.
    public static final Enterable enterableOcean = new Enterable() {
                    public boolean canEnter(Player p) {
                        return p.isPegasus();
                    }
                    public void enter(Player p) {
                        p.getNarrator().getTime().addMinute(10);
                    }
                };
    public static final Enterable enterableMountain = new Enterable() {
                public boolean canEnter(Player p) {
                    return p.isPegasus();
                }
                public void enter(Player p) {
                    p.getNarrator().getTime().addMinute(10);
                }
            };
    public static final Enterable enterableJungle = new Enterable() {
                        public boolean canEnter(Player p) {
                            return true;
                        }
                        public void enter(Player p) {
                            p.getNarrator().getTime().addMinute(10);
                        }
                    };
    public static final Enterable enterableSwamp = new Enterable() {
                            public boolean canEnter(Player p) {
                                return true;
                            }
                            public void enter(Player p) {
                                p.getNarrator().getTime().addMinute(10);
                            }
                        };
    public static final Enterable enterableLake = new Enterable() {
                            public boolean canEnter(Player p) {
                                return p.isPegasus();
                            }
                            public void enter(Player p) {
                                p.getNarrator().getTime().addMinute(10);
                            }
                        };
    public static final Enterable enterableSnowyForest = new Enterable() {
                        public boolean canEnter(Player p) {
                            return true;
                        }
                        public void enter(Player p) {
                            p.getNarrator().getTime().addMinute(10);
                        }
                    };
    public static final Enterable enterableForest = new Enterable() {
                    public boolean canEnter(Player p) {
                        return true;
                    }
                    public void enter(Player p) {
                        p.getNarrator().getTime().addMinute(10);
                    }
                };
    public static final Enterable enterableHotPlains = new Enterable() {
                        public boolean canEnter(Player p) {
                            return true;
                        }
                        public void enter(Player p) {
                            p.getNarrator().getTime().addMinute(10);
                        }
                    };
    public static final Enterable enterablePlains = new Enterable() {
                        public boolean canEnter(Player p) {
                            return true;
                        }
                        public void enter(Player p) {
                            p.getNarrator().getTime().addMinute(10);
                        }
                    };
    public static final Enterable enterableSnowyPlains = new Enterable() {
                        public boolean canEnter(Player p) {
                            return true;
                        }
                        public void enter(Player p) {
                            p.getNarrator().getTime().addMinute(10);
                        }
                    };
    public static final Enterable enterableHotDesert = new Enterable() {
                        public boolean canEnter(Player p) {
                            return true;
                        }
                        public void enter(Player p) {
                            p.getNarrator().getTime().addMinute(10);
                        }
                    };
    public static final Enterable enterableModerateDesert = new Enterable() {
                        public boolean canEnter(Player p) {
                            return true;
                        }
                        public void enter(Player p) {
                            p.getNarrator().getTime().addMinute(10);
                        }
                    };
    public static final Enterable enterableTundra = new Enterable() {
                        public boolean canEnter(Player p) {
                            return true;
                        }
                        public void enter(Player p) {
                            p.getNarrator().getTime().addMinute(10);
                        }
                    };

    private Environment mapEnvironment;
    private char symbol;
    private String name;
    private Color color;
    private Color color2;
    private Enterable e;
    private List<Quest> quests;
    private boolean discovered;
    private TileEnvironment tileEnvironment;
    private boolean accSet;
    private boolean accessible;
    /*
    public Tile() {
        symbol = 'o';
        e = new Enterable() {
            public boolean canEnter(Person p) {
                return true;
            }

            public void enter(Person p) {
                p.getNarrator().getTime().addHour();
            }
        };
        if (Math.random() < 0) {
            discovered = true;
        } else {
            discovered = false;
        }
        color = DEFAULTCOLOR1;
        color2 = DEFAULTCOLOR2;
        environment = new TileEnvironment();
        clearSets();
    }
    public Tile(char c) {
        symbol = c;
        e = new Enterable() {
            public boolean canEnter(Person p) {
                return true;
            }

            public void enter(Person p) {
                p.getNarrator().getTime().addHour();
            }
        };
        discovered = true;
        color = DEFAULTCOLOR1;
        color2 = DEFAULTCOLOR2;
        environment = new TileEnvironment();
        clearSets();
    }
    public Tile(char c, Enterable e) {
        symbol = c;
        this.e = e;
        discovered = true;
        color = DEFAULTCOLOR1;
        color2 = DEFAULTCOLOR2;
        environment = new TileEnvironment();
        clearSets();
    }
    */
    public Tile(Environment env) {
        symbol = 'o';
        e = new Enterable() {
            public boolean canEnter(Player p) {
                return true;
            }

            public void enter(Player p) {
                p.getNarrator().getTime().addHour();
            }
        };
        if (Math.random() < 0) {
            discovered = true;
        } else {
            discovered = false;
        }
        color = DEFAULTCOLOR1;
        color2 = DEFAULTCOLOR2;
        tileEnvironment = new TileEnvironment();
        mapEnvironment = env;
        accessible = false;
        clearSets();
    }

    public String getName() {return name;}
    public void setName(String n) {name = n;}
    
    public void addQuest(Quest q) {
        getQuests().add(q);
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Enterable getE() {
        return e;
    }

    public void setE(Enterable e) {
        this.e = e;
    }

    public boolean canEnter(Player p) {
        if (e != null) {
            return e.canEnter(p);
        } else {
            return true;
        }
    }

    public void enter(Player p) {
        if (e != null) {
            e.enter(p);
        } else {
            //Do nothing.
        }
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    public String toString() {
        return "" + symbol;
    }

    public boolean isDiscovered() {
        return discovered;
    }

    public void setDiscovered(boolean discovered) {
        this.discovered = discovered;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean looksSame(Tile t) {
        return color.equals(t.getColor()) && color2.equals(t.getColor2()) && symbol == t.getSymbol();
    }

    public boolean looksSame(Tile t, Color c2) {
        return color.equals(t.getColor()) && c2.equals(t.getColor2()) && symbol == t.getSymbol();
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public double getDepth() {
        return getTileEnvironment().getDepth();
    }

    public void setDepth(double depth) {
        getTileEnvironment().setDepth(depth);
    }

    public boolean isDepthSet() {
        return getTileEnvironment().isDepthSet();
    }

    public void setDepthSet(boolean depthSet) {
        getTileEnvironment().setDepthSet(depthSet);
    }

    public double getHumidity() {
        return getTileEnvironment().getHumidity();
    }

    public void setHumidity(double humidity) {
        getTileEnvironment().setHumidity(humidity);
    }

    public boolean isHumiditySet() {
        return getTileEnvironment().isHumiditySet();
    }

    public void setHumiditySet(boolean humiditySet) {
        getTileEnvironment().setHumiditySet(humiditySet);
    }

    public double waterBonus() {
        if (getDepth() < 0) {
            return 1;
        } else if(getDepth() > 10) {
            return 0;
        } else {
            return 0.1;
        }
    }
    public static double waterBonus(double d) {
        if (d < 0) {
            return 1;
        } else if(d > 10) {
            return 0;
        } else {
            return 0.1;
        }
    }

    public double getTemperatureH() {
        return getTileEnvironment().getTemperatureH();
    }

    public void setTemperatureH(double temperatureH) {
        getTileEnvironment().setTemperatureH(temperatureH);
    }

    public double getTemperatureL() {
        return getTileEnvironment().getTemperatureL();
    }

    public void setTemperatureL(double temperatureL) {
        getTileEnvironment().setTemperatureL(temperatureL);
    }

    public boolean isTemperatureHSet() {
        return getTileEnvironment().isTemperatureHSet();
    }

    public void setTemperatureHSet(boolean temperatureHSet) {
        getTileEnvironment().setTemperatureHSet(temperatureHSet);
    }

    public boolean isTemperatureLSet() {
        return getTileEnvironment().isTemperatureLSet();
    }

    public void setTemperatureLSet(boolean temperatureLSet) {
        getTileEnvironment().setTemperatureLSet(temperatureLSet);
    }

    public double getTemperatureAverage() {
        return (getTemperatureH() + getTemperatureL()) / 2;
    }

    public double getTemperatureVariance() {
        return (getTemperatureH() - getTemperatureL()) / 2;
    }
    
    public double getCurrentTemperature() {
        double M = getTemperatureVariance();
        double m = M/2;
        return getTemperatureAverage()
                - (M-m)*Math.cos(2*Math.PI/365 * mapEnvironment.getTime().getDay())
                - m*Math.cos(Math.PI/12 * ((double)mapEnvironment.getTime().getMinute()/60 + mapEnvironment.getTime().getHour()));
    }

    public void clearSets() {
        setDepthSet(false);
        setHumiditySet(false);
        setTemperatureHSet(false);
        setTemperatureLSet(false);
    }

    public Color jungleGreen() {
        return new Color(Func.randInt(0, 5), 70 + Func.randInt(-10, 10), Func.randInt(0, 5));
    }
    public Color swampGreen() {
        return new Color(30 + Func.randInt(0, 5), 70 + Func.randInt(-10, 10), 10 + Func.randInt(0, 5));
    }
    public Color forestGreen() {
        return new Color(Func.randInt(0, 5), 118 + Func.randInt(-10, 10), Func.randInt(0, 5));
    }
    public Color forest2Green() {
        return new Color(200 + Func.randInt(0, 5), 220 + Func.randInt(0, 10), 200 + Func.randInt(0, 5));
    }
    public Color plainsGreen() {
        return new Color(Func.randInt(0, 5), 152 + Func.randInt(-10, 10), Func.randInt(0, 5));
    }
    public Color plainsBrown() {
        return new Color(100 + Func.randInt(0, 5), 140 + Func.randInt(0, 5), 40 + Func.randInt(0, 5));
    }
    public Color plainsWhite() {
        return new Color(190 + Func.randInt(0, 5), 240 + Func.randInt(0, 10), 190 + Func.randInt(0, 5));
    }
    public Color desertYellow() {
        return new Color(240 + Func.randInt(0, 5), 230 + Func.randInt(0, 5), 0 + Func.randInt(0, 5));
    }
    public Color desertBrown() {
        return new Color(120 + Func.randInt(0, 5), 100 + Func.randInt(0, 5), 40 + Func.randInt(0, 5));
    }
    public Color oceanBlue() {
        return new Color(Func.randInt(0, 5), Func.randInt(0, 5), 240 + Func.randInt(0, 5));
    }
    public Color oceanWhite() {
        return new Color(150 + Func.randInt(0, 5), 150 + Func.randInt(0, 5), 240 + Func.randInt(0, 5));
    }
    public Color glacierWhite() {
        return new Color(200 + Func.randInt(0, 5), 200 + Func.randInt(0, 5), 240 + Func.randInt(0, 5));
    }
    public Color tundraWhite() {
        return new Color(240 + Func.randInt(0, 5), 240 + Func.randInt(0, 5), 240 + Func.randInt(0, 5));
    }
    public Color mountainGray() {
        return new Color(64 + Func.randInt(0, 5), 64 + Func.randInt(0, 5), 64 + Func.randInt(0, 5));
    }

    public void determine() {
        if (getDepth() < 0) {
            if(getTemperatureH() < 0) {
                name = "Glacier";
                symbol = 'g';
                color = glacierWhite();
                color2 = color;
                e = enterableGlacier;
            } else if(getTemperatureL() < 0) {
                name = "Frozen Ocean";
                symbol = 'o';
                color = oceanWhite();
                color2 = color;
                e = new Enterable() {
                    public boolean canEnter(Player p) {
                        return p.isPegasus() || getCurrentTemperature() < 0;
                    }
                    public void enter(Player p) {
                        p.getNarrator().getTime().addMinute(10);
                        if(getCurrentTemperature() > 0 && !p.isPegasus()) {p.setAlive(false); p.setDeathMessage("You drowned.");}
                    }
                };
            } else {
                name = "Ocean";
                symbol = 'o';
                color = oceanBlue();
                color2 = color;
                e = enterableOcean;
            }
        } else if (getDepth() > 15) {
            name = "Mountain";
            symbol = '^';
            color = mountainGray();
            color2 = Color.white;
            e = enterableMountain;
        } else {
            if(getHumidity() > 25) {
                if (getTemperatureAverage() > 20) {
                    name = "Jungle";
                    symbol = 'J';
                    color = jungleGreen();
                    color2 = Color.white;
                    e = enterableJungle;
                } else if(getTemperatureAverage() > 5) {
                    if(getHumidity()-getDepth() < 30) {
                        name = "Swamp";
                        symbol = 's';
                        color = swampGreen();
                        color2 = oceanBlue();
                        e = enterableSwamp;
                    } else {
                        name = "Lake";
                        symbol = 'l';
                        color = oceanBlue();
                        color2 = oceanBlue();
                        e = enterableLake;
                    }
                } else {
                    name = "Snowy Forest";
                    symbol = 'f';
                    color = forest2Green();
                    color2 = Color.white;
                    e = enterableSnowyForest;
                }
            } else if (getHumidity() > 15) {
                if (getTemperatureAverage() > 5) {
                    name = "Forest";
                    symbol = 'f';
                    color = forestGreen();
                    color2 = Color.white;
                    e = enterableForest;
                } else {
                    name = "Snowy Forest";
                    symbol = 'f';
                    color = forest2Green();
                    color2 = Color.white;
                    e = enterableSnowyForest;
                }
            } else if(getHumidity() > 7.5) {
                if(getTemperatureAverage() > 20) {
                    name = "Hot Plains";
                    symbol = 'v';
                    color = plainsBrown();
                    color2 = Color.white;
                    e = enterableHotPlains;
                } else if(getTemperatureAverage() > 5) {
                    name = "Plains";
                    symbol = 'v';
                    color = plainsGreen();
                    color2 = Color.white;
                    e = enterablePlains;
                } else {
                    name = "Snowy Plains";
                    symbol = 'v';
                    color = plainsWhite();
                    color2 = Color.white;
                    e = enterableSnowyPlains;
                }
            } else {
                if (getTemperatureAverage() > 10) {
                    name = "Hot Desert";
                    symbol = '~';
                    color = desertYellow();
                    color2 = Color.white;
                    e = enterableHotDesert;
                } else if(getTemperatureAverage() > 0) {
                    name = "Moderate Desert";
                    symbol = '~';
                    color = desertBrown();
                    color2 = Color.white;
                    e = enterableModerateDesert;
                } else {
                    name = "Tundra";
                    symbol = '~';
                    color = tundraWhite();
                    color2 = Color.white;
                    e = enterableTundra;
                }
            }
        }
    }
    
    public void set(Tile t) {
        name = t.getName();
        symbol = t.getSymbol();
        color = t.getColor();
        color2 = t.getColor2();
        e = t.getE();
    }

    public TileEnvironment getTileEnvironment() {
        return tileEnvironment;
    }
    public void setTileEnvironment(TileEnvironment env) {
        this.tileEnvironment = env;
    }
    
    public boolean isTerrainAccessible() {
        switch(symbol) {
        case('l'):
            return false;
        case('o'):
            return false;
        case('g'):
            return false;
        case('^'):
            return false;
        default:
            return true;
        }
    }
    
    public boolean isAccSet() {return accSet;}
    public void setAccSet(boolean b) {accSet = b;}
    public boolean isAccessible() {return accessible;}
    public void setAccessible(boolean b) {accessible = b;}
}


