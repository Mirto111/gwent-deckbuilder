package org.myproject.deckbuilder.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public enum Faction {

  Monster,
  Skellige,
  Northern_Realms,
  Scoiatael,
  Nilfgaard,
  Neutral,
  Syndicate;

  /*Monster("Monster"),
  SKELLIGE("Skellige"),
  NORTHERN_REALMS("Northern Realms"),
  SCOIATAEL("Scoiatael"),
  NILFGAARD("Nilfgaard"),
  NEUTRAL("Neutral");*/


  // private static final Map<String, Faction> BY_LABEL = new HashMap<>();
  //
  // static {
  //   for (Faction f: values()) {
  //     BY_LABEL.put(f.faction, f);
  //   }
  // }
  //
  //
  // private String faction;
  //
  // private Faction(String faction) {
  //   this.faction = faction;
  // }
  //
  //
  // public static Faction valueOfFaction(@JsonProperty("faction")String faction) {
  //   return Optional.ofNullable(BY_LABEL.get(faction)).orElseThrow((
  //       () -> new IllegalArgumentException("No enum Constant " +faction))) ;
  // }
  //
  //
  // public String getFaction() {
  //   return faction;
  // }

}
