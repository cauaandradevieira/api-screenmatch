package com.testando_api.primeiro_teste_api.ordenar.comparator;

import com.testando_api.primeiro_teste_api.model.EpisodeModel;

import java.util.Comparator;

public class EpisodeComparator
{

    public static Comparator<EpisodeModel> returnComparatorAvaliation(String ordem)
    {
        return ordem.equalsIgnoreCase("desc") ? Comparator.comparingDouble(EpisodeModel::getAvaliation).reversed() :
                Comparator.comparingDouble(EpisodeModel::getAvaliation);
    }
}
