module JSONTest
{
  value LongLegs {
    Long  oneLong;
    Long? optLong;
    
    Long[]   arrLong;
    Long?[]  arrOptLong;
    Long[]?  optArrLong;
    Long?[]? optArrOptLong;
    
    List<Long>   listLong;
    List<Long?>  listOptLong;
    List<Long>?  optListLong;
    List<Long?>? optListOptLong;
    
    Set<Long>   setLong;
    Set<Long?>  setOptLong;
    Set<Long>?  optSetLong;
    Set<Long?>? optSetOptLong;
  }
  
  value MummyVal {
    LongLegs  oneLL;
    LongLegs? optLL;
    
    LongLegs[]   arrLL;
    LongLegs?[]  arrOptLL;
    LongLegs[]?  optArrLL;
    LongLegs?[]? optArrOptLL;
    
    List<LongLegs>   listLL;
    List<LongLegs?>  listOptLL;
    List<LongLegs>?  optListLL;
    List<LongLegs?>? optListOptLL;
    
    Set<LongLegs>   setLL;
    Set<LongLegs?>  setOptLL;
    Set<LongLegs>?  optSetLL;
    Set<LongLegs?>? optSetOptLL;
  }
  
  value Guidlicious {
    UUID  oneGuid;
    UUID? optGuid;
    
    UUID[]   arrGuid;
    UUID?[]  arrOptGuid;
    UUID[]?  optArrGuid;
    UUID?[]? optArrOptGuid;
    
    List<UUID>   listGuid;
    List<UUID?>  listOptGuid;
    List<UUID>?  optListGuid;
    List<UUID?>? optListOptGuid;
    
    Set<UUID>   setGuid;
    Set<UUID?>  setOptGuid;
    Set<UUID>?  optSetGuid;
    Set<UUID?>? optSetOptGuid;
  }
  
  aggregate StringlyTyped {
    String  oneStr;
    String? optStr;
    
    String[]   arrStr;
    String?[]  arrOptStr;
    String[]?  optArrStr;
    String?[]? optArrOptStr;
    
    List<String>   ListStr;
    List<String?>  ListOptStr;
    List<String>?  optListStr;
    List<String?>? optListOptStr;
    
    Set<String>   setStr;
    Set<String?>  setOptStr;
    Set<String>?  optSetStr;
    Set<String?>? optSetOptStr;
  }
  
  aggregate RootlyTyped {
    StringlyTyped  *oneRoot;
    StringlyTyped? *optRoot;
    
    StringlyTyped[]   *arrRoot;
    StringlyTyped?[]  *arrOptRoot;
    StringlyTyped[]?  *optArrRoot;
    StringlyTyped?[]? *optArrOptRoot;
    
    List<StringlyTyped>   *ListRoot;
    List<StringlyTyped?>  *ListOptRoot;
    List<StringlyTyped>?  *optListRoot;
    List<StringlyTyped?>? *optListOptRoot;
    
    Set<StringlyTyped>   *setRoot;
    Set<StringlyTyped?>  *setOptRoot;
    Set<StringlyTyped>?  *optSetRoot;
    Set<StringlyTyped?>? *optSetOptRoot;
  }
}
