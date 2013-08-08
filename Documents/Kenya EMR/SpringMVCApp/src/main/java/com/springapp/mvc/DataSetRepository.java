package com.springapp.mvc;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springapp.mvc.syncmodel.*;
public interface DataSetRepository  extends JpaRepository<SyncDataSet, Long> {


}
