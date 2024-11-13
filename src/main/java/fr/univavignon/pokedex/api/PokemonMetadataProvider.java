package fr.univavignon.pokedex.api;

import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider {
    List<PokemonMetadata> pokemonMetadatas = List.of(
        new PokemonMetadata(0, "Bulbizarre", 126, 126, 90),
        new PokemonMetadata(133, "Aquali", 186, 168, 260)
    );

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (index < 0 || index > 150) throw new PokedexException("Invalid index ("+index+") must be 0..150");

        return pokemonMetadatas.stream()
                .filter(metadata -> metadata.getIndex() == index)
                .findFirst()
                .orElseThrow(() -> new PokedexException("Pokemon nout found"));
    }
    
}
