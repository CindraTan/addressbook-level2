package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class Tagging {
	public enum TagAction {ADD, REMOVE};
	
	private ReadOnlyPerson person;
	private UniqueTagList tag;
	private TagAction tagAction;
	
	public Tagging(ReadOnlyPerson person, UniqueTagList uniqueTagList, TagAction tagAction) {
		this.setPerson(person);
		this.setTag(uniqueTagList);
		this.setTagAction(tagAction);
	}

	public ReadOnlyPerson getPerson() {
		return person;
	}

	public void setPerson(ReadOnlyPerson person) {
		this.person = person;
	}

	public UniqueTagList getTag() {
		return tag;
	}

	public void setTag(UniqueTagList tag) {
		this.tag = tag;
	}

	public TagAction getTagAction() {
		return tagAction;
	}

	public void setTagAction(TagAction tagAction) {
		this.tagAction = tagAction;
	}	
}
