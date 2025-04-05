package com.testando_api.primeiro_teste_api.ordenar;

import com.testando_api.primeiro_teste_api.dado.IDados;
import com.testando_api.primeiro_teste_api.model.EpisodeModel;
import com.testando_api.primeiro_teste_api.model.SerieModel;
import com.testando_api.primeiro_teste_api.ordenar.comparator.EpisodeComparator;

import java.util.Comparator;

public class OrdenarSerie implements IOrdenarAvaliação<SerieModel>
{
    @Override
    public void ordenarPorAvaliação(SerieModel serieModel, IDados dados, String ordem)
    {
        Comparator<EpisodeModel> comparator = EpisodeComparator.returnComparatorAvaliation(ordem);

        serieModel.getListaTemporadas().stream()
                .flatMap(t -> t.getListaEpisodios().stream())
                .filter(e -> !e.getAvaliation().equals(0.0))
                .sorted(comparator)
                .forEach(dados::mostrarJsonDo);
    }

    @Override
    public void ordenarPorAvaliaçãoTop10(SerieModel serieModel, IDados dados ,String ordem) {
        Comparator<EpisodeModel> comparator = EpisodeComparator.returnComparatorAvaliation(ordem);

        serieModel.getListaTemporadas().stream()
                .flatMap(t -> t.getListaEpisodios().stream())
                .filter(e -> !e.getAvaliation().equals(0.0))
                .sorted(comparator)
                .limit(10)
                .forEach(dados::mostrarJsonDo);
    }
}
