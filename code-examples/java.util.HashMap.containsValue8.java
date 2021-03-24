private void deleteClasses(InstructionalOfferingModifyForm frm, InstrOfferingConfig ioc, Session hibSession, HashMap tmpClassIdsToRealClasses){
 	if (ioc.getSchedulingSubparts() != null) {
SchedulingSubpart ss = null;
ArrayList lst = new ArrayList();
      ArrayList subpartList = new ArrayList(ioc.getSchedulingSubparts());
      Collections.sort(subpartList, new SchedulingSubpartComparator());

      for(Iterator it = subpartList.iterator(); it.hasNext();){
      	ss = (SchedulingSubpart) it.next();
      	if (ss.getParentSubpart() == null){
      		buildClassList(ss.getClasses(), lst);
      	}
      }

      Class_ c;
      for (int i = (lst.size() - 1); i >= 0; i--){
      	c = (Class_) lst.get(i);
      	if (!frm.getClassIds().contains(c.getUniqueId().toString()) && !tmpClassIdsToRealClasses.containsValue(c)){
		if (c.getParentClass() != null){
			Class_ parent = c.getParentClass();
			parent.getChildClasses().remove(c);
			hibSession.update(parent);
		}
		c.getSchedulingSubpart().getClasses().remove(c);
		if (c.getPreferences() != null)
		    c.getPreferences().removeAll(c.getPreferences());
		
		c.deleteAllDependentObjects(hibSession, false);
		
		hibSession.delete(c);
      	}
      }
 	}
  }