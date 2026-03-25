package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        Magasin app = new Magasin(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void checkUpdateQualityComte() {
        Item[] items = new Item[]{
                new Item("Comté", 10, 50),
                new Item("Comté", 0, 10),
                new Item("Comté", -1, 50),
        };

        Item[] itemsV2 = new Item[]{

                new Item("Comté", 10, 50),
                new Item("Comté", 0, 10),
                new Item("Comté", -1, 50),
        };


        Magasin app = new Magasin(items);
        MagasinV2 appV2 = new MagasinV2(itemsV2);


        app.updateQuality();
        appV2.updateQuality();

        assertEquals(toString(app.items), toString(appV2.items));


    }

    @Test
    void checkUpdateQualityPass() {
        Item[] items = new Item[]{
                new Item("Pass VIP Concert", 15, 40),
                new Item("Pass VIP Concert", 5, 40),
                new Item("Pass VIP Concert", 5, 49),
                new Item("Pass VIP Concert", 0, 50),

        };
        Item[] itemsV2 = new Item[]{
                new Item("Pass VIP Concert", 15, 40),
                new Item("Pass VIP Concert", 5, 40),
                new Item("Pass VIP Concert", 5, 49),
                new Item("Pass VIP Concert", 0, 50),
        };

        Magasin app = new Magasin(items);
        MagasinV2 appV2 = new MagasinV2(itemsV2);


        app.updateQuality();
        appV2.updateQuality();

        assertEquals(toString(app.items), toString(appV2.items));


    }

    @Test
    void checkUpdateQualityKryptonite() {
        Item[] items = new Item[]{
                new Item("Kryptonite", 15, 80),
                new Item("Kryptonite", -1, 80),
        };
        Item[] itemsV2 = new Item[]{
                new Item("Kryptonite", 15, 80),
                new Item("Kryptonite", -1, 80)
        };

        Magasin app = new Magasin(items);
        MagasinV2 appV2 = new MagasinV2(itemsV2);


        app.updateQuality();
        appV2.updateQuality();

        assertEquals(toString(app.items), toString(appV2.items));


    }

    @Test
    void checkUpdateQualityLambda() {
        Item[] items = new Item[]{
                new Item("Lambda", 15, 50),
                new Item("Lambda", 1, 50),
                new Item("Lambda", -1, 4)


        };
        Item[] itemsV2 = new Item[]{
                new Item("Lambda", 15, 50),
                new Item("Lambda", 1, 50),
                new Item("Lambda", -1, 4)
        };

        Magasin app = new Magasin(items);
        MagasinV2 appV2 = new MagasinV2(itemsV2);


        app.updateQuality();
        appV2.updateQualityBasic();

        assertEquals(toString(app.items), toString(appV2.items));

    }


    private String toString(Item[] items) {
        StringBuilder s = new StringBuilder();
        for (Item item : items) {
            s.append(item.toString() + "\n");
        }
        return s.toString();
    }
}


