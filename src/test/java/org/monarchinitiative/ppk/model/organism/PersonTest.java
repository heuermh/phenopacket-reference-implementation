package org.monarchinitiative.ppk.model.organism;

import org.junit.Test;
import org.monarchinitiative.ppk.PhenoPacket;
import org.monarchinitiative.ppk.io.JsonGenerator;
import org.monarchinitiative.ppk.io.JsonReader;
import org.monarchinitiative.ppk.io.YamlGenerator;
import org.monarchinitiative.ppk.io.YamlReader;
import org.monarchinitiative.ppk.model.entity.Person;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonTest {

	/**
	 * TODO: is this the best strategy for testing? See https://github.com/phenopackets/phenopacket-reference-implementation/issues/14
	 * 
	 * @throws IOException
	 */
	@Test
	public void testYaml() throws IOException {
		PhenoPacket packet = YamlReader.readFile(Paths.get("src/test/resources/organism/persons-example1.yaml").toFile());
		System.out.println(YamlGenerator.render(packet));

		List<Person> persons = packet.getPersons();
		assertTrue(persons.size() == 3);
		// order is preserved
		System.out.println(persons.get(0));
		assertEquals("#1", persons.get(0).getId());
		assertEquals("M", persons.get(0).getSex());
		assertEquals("1999-01-01", persons.get(0).getDateOfBirth());
	}

	@Test
	public void testJson() throws IOException {
		PhenoPacket packet = JsonReader.readFile(Paths.get("src/test/resources/organism/persons-example1.json").toFile());
		System.out.println(JsonGenerator.render(packet));

		List<Person> persons = packet.getPersons();
		assertTrue(persons.size() == 3);
		// order is preserved
		System.out.println(persons.get(0));
		assertEquals("#1", persons.get(0).getId());
		assertEquals("M", persons.get(0).getSex());
		assertEquals("1999-01-01", persons.get(0).getDateOfBirth());

	}
}
