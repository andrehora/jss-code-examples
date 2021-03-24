private static Node generateRootWithGhostTutor(List<Tutor> tutors, List<Course> courses, List<Shift> shifts) {
    HashMap<Rank, Set<Course>> ghostCoursePreferences = new HashMap<>();
    ghostCoursePreferences.put(Rank.PREFER, new HashSet<>(courses));

    HashMap<Rank, Set<Shift>> ghostShiftPreferences = new HashMap<>();
    ghostShiftPreferences.put(Rank.PREFER, new HashSet<>(shifts));

    HashMap<Rank, Integer> ghostShiftFrequencyPreferences = new HashMap<>();
    ghostShiftFrequencyPreferences.put(Rank.PREFER, Integer.MAX_VALUE);

    TutorPreferences ghostTutorPreference = new TutorPreferences(ghostCoursePreferences, ghostShiftPreferences, ghostShiftFrequencyPreferences);
    Tutor ghostTutor = new Tutor(-1, "Ghost", "Tutor", ghostTutorPreference, TutorStatus.ACTIVE);

    tutors.add(ghostTutor);
    return generateRoot(tutors, courses, shifts);
}