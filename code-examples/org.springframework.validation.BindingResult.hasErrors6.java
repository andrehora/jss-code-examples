@RequestMapping(value = "/new", method = RequestMethod.POST)
public String createEvent(@Valid CreateEventForm createEventForm, BindingResult result,
        RedirectAttributes redirectAttributes) {
    if (result.hasErrors()) {
        return "events/create";
    }
    CalendarUser attendee = calendarService.findUserByEmail(createEventForm.getAttendeeEmail());
    if (attendee == null) {
        result.rejectValue("attendeeEmail", "attendeeEmail.missing",
                "Could not find a user for the provided Attendee Email");
    }
    if (result.hasErrors()) {
        return "events/create";
    }
    Event event = new Event();
    event.setAttendee(attendee);
    event.setDescription(createEventForm.getDescription());
    event.setOwner(userContext.getCurrentUser());
    event.setSummary(createEventForm.getSummary());
    event.setWhen(createEventForm.getWhen());
    calendarService.createEvent(event);
    redirectAttributes.addFlashAttribute("message", "Successfully added the new event");
    return "redirect:/events/my";
}