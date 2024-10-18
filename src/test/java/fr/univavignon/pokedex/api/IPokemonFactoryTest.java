package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static fr.univavignon.pokedex.api.IPokemonMetadataProviderTest.bulbizarreMetadata;
import static fr.univavignon.pokedex.api.IPokemonMetadataProviderTest.evoliMetadata;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class IPokemonFactoryTest {
	static IPokemonFactory pokemonFactory;
	static PokemonData bulbizarreData = new PokemonData(bulbizarreMetadata,
			613, 64, 4000, 4);
	static Pokemon bulbizarre = new Pokemon(bulbizarreMetadata.getIndex(), bulbizarreMetadata.getName(), bulbizarreMetadata.getAttack(),
			bulbizarreMetadata.getDefense(), bulbizarreMetadata.getStamina(), bulbizarreData.cp, bulbizarreData.hp,
			bulbizarreData.dust, bulbizarreData.candy, 0.56);

	static PokemonData evoliData = new PokemonData(evoliMetadata,
			2729, 202, 5000, 4);
	static Pokemon evoli = new Pokemon(evoliMetadata.getIndex(), evoliMetadata.getName(), evoliMetadata.getAttack(),
				evoliMetadata.getDefense(), evoliMetadata.getStamina(), evoliData.cp, evoliData.hp,
				evoliData.dust, evoliData.candy, 1.0);

	@BeforeAll
	static void setPokemonFactory() {
		pokemonFactory = mock(IPokemonFactory.class);

		when(pokemonFactory.createPokemon(eq(bulbizarre.getIndex()), anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(bulbizarre);
		when(pokemonFactory.createPokemon(eq(evoli.getIndex()), anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(evoli);
	}

	@Test
	void bulbizarreFactory() {
		Pokemon bulbizarreTest = pokemonFactory.createPokemon(bulbizarreData.pokemonMetadata.getIndex(), bulbizarreData.cp, bulbizarreData.hp, bulbizarreData.dust, bulbizarreData.candy);
		assertEquals(bulbizarreTest, bulbizarre);
	}

	@Test
	void evoliFactory() {
		Pokemon evoliTest = pokemonFactory.createPokemon(evoliData.pokemonMetadata.getIndex(), evoliData.cp, evoliData.hp, evoliData.dust, evoliData.candy);
		assertEquals(evoliTest, evoli);
	}

	static class PokemonData {
		PokemonMetadata pokemonMetadata;
		int cp;
		int hp;
		int dust;
		int candy;

		public PokemonData(PokemonMetadata pokemonMetadata, int cp, int hp, int dust, int candy) {
			this.pokemonMetadata = pokemonMetadata;
			this.cp = cp;
			this.hp = hp;
			this.dust = dust;
			this.candy = candy;
		}
	}
}
