package com.magasin;

public class MagasinV2 {
    Item[] items;

    public MagasinV2(Item[] items) {
        this.items = items;
    }

    public void updateQualityBasic(Item item) {

        if (item.sellIn > 0) {
            item.quality -= 1;
        } else {
            item.quality -= 5;
        }
        item.sellIn -= 1;

    }

    public void updateQualityComte(Item item) {

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

    public void updateQualityPassVipConcert(Item item) {

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

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name){
                case "Comté" : updateQualityComte(item);
                break;
                case "Pass VIP Concert" : updateQualityPassVipConcert(item);
                break;
                case "Kryptonite" : break;
                default: updateQualityBasic(item);
                break;
            }

        }
    }
}
