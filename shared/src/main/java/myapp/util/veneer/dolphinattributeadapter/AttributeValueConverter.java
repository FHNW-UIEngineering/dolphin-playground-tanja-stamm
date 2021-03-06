package myapp.util.veneer.dolphinattributeadapter;


public interface AttributeValueConverter<T> {
    Object toAttributeValue(T value);

    T toPropertyValue(Object value);
}
