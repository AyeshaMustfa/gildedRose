package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item currentItem = items[i];

            // Update sellIn for all items, except for "Sulfuras"
            if (!currentItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                currentItem.sellIn = currentItem.sellIn - 1;
            }

            // Update quality based on item type
            if (currentItem.name.equals("Aged Brie")) {
                updateAgedBrie(currentItem);
            } else if (currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstagePasses(currentItem);
            } else if (currentItem.name.equals("Conjured")) {
                updateConjured(currentItem);
            } else {
                updateNormalItem(currentItem);
            }

            // Ensure quality is within bounds
            if (currentItem.quality < 0) {
                currentItem.quality = 0;
            } else if (currentItem.quality > 50 && !currentItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                currentItem.quality = 50;
            }
        }
    }

    private void updateNormalItem(Item item) {
        if (item.quality > 0) {
            if (item.sellIn < 0) {
                item.quality = item.quality - 2;
            } else {
                item.quality = item.quality - 1;
            }
        }
    }

    private void updateAgedBrie(Item item) {
        if (item.quality < 50) {
            if (item.sellIn < 0) {
                item.quality = item.quality + 2;
            } else {
                item.quality = item.quality + 1;
            }
        }
    }

    private void updateBackstagePasses(Item item) {
        if (item.quality < 50) {
            if (item.sellIn < 0) {
                item.quality = 0;
            } else if (item.sellIn < 6) {
                item.quality = item.quality + 3;
            } else if (item.sellIn < 11) {
                item.quality = item.quality + 2;
            } else {
                item.quality = item.quality + 1;
            }
        }
    }

    private void updateConjured(Item item) {
        if (item.quality > 0) {
            if (item.sellIn < 0) {
                item.quality = item.quality - 4;
            } else {
                item.quality = item.quality - 2;
            }
        }
    }
}
