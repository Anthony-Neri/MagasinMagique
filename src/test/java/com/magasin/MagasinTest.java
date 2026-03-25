package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }
    @Test
    void checkUpdateQualityComte() {
        Item[] items = new Item[]{new Item("Comté", 10, 10)};
        Item[] itemsV2 = new Item[]{new Item("Comté", 10, 10)};

        Magasin app = new Magasin(items);
        MagasinV2 appV2 = new MagasinV2(itemsV2);
        for (int i = 0; i < 50; i++) {

            app.updateQuality();
            appV2.updateQuality();

            assertEquals(app.items[0].quality, appV2.items[0].quality);
            assertEquals(app.items[0].sellIn, appV2.items[0].sellIn);

        }
    }

        @Test
        void checkUpdateQualityPass() {
            Item[] items = new Item[] { new Item("Pass VIP Concert", 15, 20) };
            Item[] itemsV2 = new Item[] { new Item("Pass VIP Concert", 15, 20) };

            Magasin app = new Magasin(items);
            MagasinV2 appV2 = new MagasinV2(itemsV2);
            for (int i = 0 ; i < 50 ; i++) {

                app.updateQuality();
                appV2.updateQuality();

                assertEquals(app.items[0].quality,appV2.items[0].quality);
                assertEquals(app.items[0].sellIn,appV2.items[0].sellIn);
            }
        }





}


