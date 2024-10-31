package io.github.java_servlet.instance;

import java.util.ArrayList;
import java.util.List;

public class GetMutterListLogic {
    public List<Mutter> execute() {
        MuttersDAO dao = new MuttersDAO();
        return dao.findAll();
    }
}
