package com.doublev2v.foundation.updatable;

import java.io.Serializable;

import com.doublev2v.foundation.core.model.Identified;

public interface IdentifiedUpdatable<PK extends Serializable,D> extends Identified<PK>,Updateble<D> {

}
