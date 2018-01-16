package crocusoft.android.myapp.pts.network.responses;

import java.util.Arrays;

/**
 * Created by Asus on 1/16/2018.
 */

public class FormInputs {
    String id;
    String templateId;
    String typeId;
    String typeName;
    String array;
    String arrayId;
    String dependedArrayId;
    String name;
    String description;
    String hasPlaceholder;
    String placeholder;
    String order;
    String dependedArray;
    String multiselectional;
    String required;
    private ArrayItems[] arrayItems;

    @Override
    public String toString() {
        return "FormInputs{" +
                "id='" + id + '\'' +
                ", templateId='" + templateId + '\'' +
                ", typeId='" + typeId + '\'' +
                ", typeName='" + typeName + '\'' +
                ", array='" + array + '\'' +
                ", arrayId='" + arrayId + '\'' +
                ", dependedArrayId='" + dependedArrayId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", hasPlaceholder='" + hasPlaceholder + '\'' +
                ", placeholder='" + placeholder + '\'' +
                ", order='" + order + '\'' +
                ", dependedArray='" + dependedArray + '\'' +
                ", multiselectional='" + multiselectional + '\'' +
                ", required='" + required + '\'' +
                ", arrayItems=" + Arrays.toString(arrayItems) +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getArray() {
        return array;
    }

    public void setArray(String array) {
        this.array = array;
    }

    public String getArrayId() {
        return arrayId;
    }

    public void setArrayId(String arrayId) {
        this.arrayId = arrayId;
    }

    public String getDependedArrayId() {
        return dependedArrayId;
    }

    public void setDependedArrayId(String dependedArrayId) {
        this.dependedArrayId = dependedArrayId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHasPlaceholder() {
        return hasPlaceholder;
    }

    public void setHasPlaceholder(String hasPlaceholder) {
        this.hasPlaceholder = hasPlaceholder;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getDependedArray() {
        return dependedArray;
    }

    public void setDependedArray(String dependedArray) {
        this.dependedArray = dependedArray;
    }

    public String getMultiselectional() {
        return multiselectional;
    }

    public void setMultiselectional(String multiselectional) {
        this.multiselectional = multiselectional;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public ArrayItems[] getArrayItems() {
        return arrayItems;
    }

    public void setArrayItems(ArrayItems[] arrayItems) {
        this.arrayItems = arrayItems;
    }


}
