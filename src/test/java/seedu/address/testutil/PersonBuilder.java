package seedu.address.testutil;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.AcadLevel;
import seedu.address.model.person.AcadStream;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Remark;
import seedu.address.model.person.School;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_SCHOOL = "";
    public static final String DEFAULT_ACAD_STREAM = "";
    public static final String DEFAULT_ACAD_LEVEL = "";
    public static final String DEFAULT_REMARK = "";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private School school;
    private AcadStream acadStream;
    private AcadLevel acadLevel;
    private Remark remark;
    private Set<Tag> tags;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        school = new School(DEFAULT_SCHOOL);
        acadStream = new AcadStream(DEFAULT_ACAD_STREAM);
        acadLevel = new AcadLevel(DEFAULT_ACAD_LEVEL);
        remark = new Remark(DEFAULT_REMARK);
        tags = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        address = personToCopy.getAddress();
        school = personToCopy.getSchool();
        acadStream = personToCopy.getAcadStream();
        acadLevel = personToCopy.getAcadLevel();
        remark = personToCopy.getRemark();
        tags = new HashSet<>(personToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code School} of the {@code Person} that we are building.
     */
    public PersonBuilder withSchool(String school) {
        this.school = new School(school);
        return this;
    }

    /**
     * Sets the {@code School} of the {@code Person} that we are building as blank.
     */
    public PersonBuilder withSchool() {
        this.school = new School(DEFAULT_SCHOOL);
        return this;
    }

    /**
     * Sets the {@code AcadStream} of the {@code Person} that we are building.
     */
    public PersonBuilder withAcadStream(String acadStream) {
        this.acadStream = new AcadStream(acadStream);
        return this;
    }

    /**
     * Sets the {@code AcadStream} of the {@code Person} that we are building as blank.
     */
    public PersonBuilder withAcadStream() {
        this.acadStream = new AcadStream(DEFAULT_ACAD_STREAM);
        return this;
    }

    /**
     * Sets the {@code AcadLevel} of the {@code Person} that we are building.
     */
    public PersonBuilder withAcadLevel(String acadLevel) {
        this.acadLevel = new AcadLevel(acadLevel);
        return this;
    }

    /**
     * Sets the {@code AcadLevel} of the {@code Person} that we are building as blank.
     */
    public PersonBuilder withAcadLevel() {
        this.acadLevel = new AcadLevel(DEFAULT_ACAD_LEVEL);
        return this;
    }

    /**
     * Sets the {@code Remark} of the {@code Person} that we are building.
     */
    public PersonBuilder withRemark(String remark) {
        this.remark = new Remark(remark);
        return this;
    }

    /**
     * Sets the {@code Remark} of the {@code Person} that we are building as blank.
     */
    public PersonBuilder withRemark() {
        this.remark = new Remark(DEFAULT_REMARK);
        return this;
    }

    public Person build() {
        return new Person(name, phone, email, address, school, acadStream, acadLevel, remark, tags);
    }
}
