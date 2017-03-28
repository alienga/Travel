package com.rat.travel.server.db;

import java.util.List;
import com.rat.travel.shared.Tour;

public interface DBInterface {
    public List<Tour> getToursList();
}
