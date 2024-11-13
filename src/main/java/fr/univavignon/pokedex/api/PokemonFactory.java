package fr.univavignon.pokedex.api;

import java.util.Random;

public class PokemonFactory implements IPokemonFactory {
    PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        double iv = new Random().nextInt(0, 32) / 31;
        try {
            PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(index);
            return new Pokemon(index, metadata.getName(),
                                metadata.getAttack() + new Random().nextInt(0, 16),
                                metadata.getDefense() + new Random().nextInt(0, 16),
                                metadata.getStamina() + new Random().nextInt(0, 16),
                                cp, hp, dust, candy, iv);  
        } catch (PokedexException e) {
            return new Pokemon(index, null, 0, 0, 0, cp, hp, dust, candy, iv);  
        }
    }    
}
