package org.myproject.deckbuilder.model;

import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class FactionTest {

  @Test
  public void testMapper() throws Exception{
    ObjectMapper mapper = new ObjectMapper();

    Faction s1 = mapper.readValue("\"Skellige\"", Faction.class);
    Faction s2 = mapper.readValue("Skellige", Faction.class);

    System.out.println(s1);
    System.out.println(s2);
  }

  @Test
  public void valueOfFaction() {
  }

  @Test
  public void getFaction() {
  }
}