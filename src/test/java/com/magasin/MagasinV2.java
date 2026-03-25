package com.magasin;

public class MagasinV2 {
    Item[] items;

    public MagasinV2(Item[] items) {
        this.items = items;
    }

    public void updateQualityBasic() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].sellIn > 0) {
                items[i].quality -= 1;
            } else {
                items[i].quality -= 2;
            }
            items[i].sellIn -= 1;
        }
    }

    public void updateQualityComte() {
        for (Item item : items) {
            if (item.sellIn > 0) {
                item.quality += 1;
            } else {
                item.quality += 2;
            }
            item.sellIn -= 1;

            if (item.quality > 50) {
                item.quality = 50;
            }
        }
    }

    public void updateQualityPassVipConcert() {
        for (Item item : items) {
            if (item.sellIn > 10) {
                item.quality += 1;
            } else if (item.sellIn > 5) {
                item.quality += 2;
            } else if (item.sellIn > 0) {
                item.quality += 3;
            } else {
                item.quality = 0;
            }

            item.sellIn -= 1;

            if (item.quality > 50) {
                item.quality = 50;
            }
        }
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Comté")
                    && !items[i].name.equals("Pass VIP Concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Kryptonite")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Pass VIP Concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Kryptonite")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Comté")) {
                    if (!items[i].name.equals("Pass VIP Concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Kryptonite")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
