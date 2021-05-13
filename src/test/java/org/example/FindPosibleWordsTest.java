package org.example;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class FindPosibleWordsTest {
    FindPossibleWords fb;

    @BeforeMethod
    public void setUp() {
        fb = new FindPossibleWords();
    }

    @Test
    public void shouldAnswerWithTrueTest1() throws IOException {
        Set<String> actual = fb.findValidWords("asdm");
        Set<String> expected = Set.of("mads", "ads", "dam", "mad", "as", "ad", "ma", "sad", "am", "dams", "mas");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldAnswerWithTrueTest2() throws IOException {
        Set<String> actual = fb.findValidWords("working");
        Set<String> expected = Set.of("rink", "koi", "ring", "own", "ion", "nori", "gor", "gowk", "wog", "kor", "gown", "rig", "wok", "inro", "rowing", "rin", "won",
                "noir", "wonk", "worn", "oink", "grow", "wino", "king", "in", "work", "kirn", "owing", " kino", "girn", "giro", "gink", "ikon", "wink", "know", "wing",
                "no", "nog", "gin", "nor", "kin", "wig", "kir", "now", "wo", "working", "row", "grown", "win", "on", "grin", "or", "irk", "wring", "ink", "ow", "go", "groin", "wrong", "giron", "iron");
        Assert.assertTrue(actual.equals(expected));
    }
}
