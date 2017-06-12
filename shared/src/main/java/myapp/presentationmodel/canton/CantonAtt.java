package myapp.presentationmodel.canton;

import myapp.presentationmodel.PMDescription;
import myapp.util.AttributeDescription;
import myapp.util.ValueType;


public enum CantonAtt implements AttributeDescription {
    ID(ValueType.ID),
    NAME(ValueType.STRING),
    MAINTOWN(ValueType.STRING),
    JOIN(ValueType.INT),
    CITIZENS(ValueType.INT),
    AREA(ValueType.INT),
    LANGUAGE(ValueType.STRING);

    private final ValueType valueType;

    CantonAtt(ValueType type) {
        valueType = type;
    }

    @Override
    public ValueType getValueType() {
        return valueType;
    }

    @Override
    public PMDescription getPMDescription() {
        return PMDescription.CANTON;
    }
}
