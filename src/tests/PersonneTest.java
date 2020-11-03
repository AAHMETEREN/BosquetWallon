package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pojo.Personne;

class PersonneTest {
	public Personne personne;
	
	public PersonneTest(Personne personne) {
        this.personne = personne;
    }

    @Test
    public final void testMyMethod_True() {
        assertTrue(this.personne.exemple1(true));
    }

}
