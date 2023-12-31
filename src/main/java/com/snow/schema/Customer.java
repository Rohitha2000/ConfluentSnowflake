/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.snow.schema;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

/** Sample schema to help you get started. */
@org.apache.avro.specific.AvroGenerated
public class Customer extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 7228581783843777471L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Customer\",\"namespace\":\"com.snow.schema\",\"doc\":\"Sample schema to help you get started.\",\"fields\":[{\"name\":\"customerid\",\"type\":\"int\",\"default\":34},{\"name\":\"customeramount\",\"type\":\"int\",\"default\":8900},{\"name\":\"customername\",\"type\":\"string\",\"default\":\"rohitha\"},{\"name\":\"paymenttype\",\"type\":\"string\",\"default\":\"Bank Transfer\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Customer> ENCODER =
      new BinaryMessageEncoder<Customer>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Customer> DECODER =
      new BinaryMessageDecoder<Customer>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Customer> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Customer> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Customer> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Customer>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Customer to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Customer from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Customer instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Customer fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private int customerid;
  private int customeramount;
  private java.lang.CharSequence customername;
  private java.lang.CharSequence paymenttype;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Customer() {}

  /**
   * All-args constructor.
   * @param customerid The new value for customerid
   * @param customeramount The new value for customeramount
   * @param customername The new value for customername
   * @param paymenttype The new value for paymenttype
   */
  public Customer(java.lang.Integer customerid, java.lang.Integer customeramount, java.lang.CharSequence customername, java.lang.CharSequence paymenttype) {
    this.customerid = customerid;
    this.customeramount = customeramount;
    this.customername = customername;
    this.paymenttype = paymenttype;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return customerid;
    case 1: return customeramount;
    case 2: return customername;
    case 3: return paymenttype;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: customerid = (java.lang.Integer)value$; break;
    case 1: customeramount = (java.lang.Integer)value$; break;
    case 2: customername = (java.lang.CharSequence)value$; break;
    case 3: paymenttype = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'customerid' field.
   * @return The value of the 'customerid' field.
   */
  public int getCustomerid() {
    return customerid;
  }


  /**
   * Sets the value of the 'customerid' field.
   * @param value the value to set.
   */
  public void setCustomerid(int value) {
    this.customerid = value;
  }

  /**
   * Gets the value of the 'customeramount' field.
   * @return The value of the 'customeramount' field.
   */
  public int getCustomeramount() {
    return customeramount;
  }


  /**
   * Sets the value of the 'customeramount' field.
   * @param value the value to set.
   */
  public void setCustomeramount(int value) {
    this.customeramount = value;
  }

  /**
   * Gets the value of the 'customername' field.
   * @return The value of the 'customername' field.
   */
  public java.lang.CharSequence getCustomername() {
    return customername;
  }


  /**
   * Sets the value of the 'customername' field.
   * @param value the value to set.
   */
  public void setCustomername(java.lang.CharSequence value) {
    this.customername = value;
  }

  /**
   * Gets the value of the 'paymenttype' field.
   * @return The value of the 'paymenttype' field.
   */
  public java.lang.CharSequence getPaymenttype() {
    return paymenttype;
  }


  /**
   * Sets the value of the 'paymenttype' field.
   * @param value the value to set.
   */
  public void setPaymenttype(java.lang.CharSequence value) {
    this.paymenttype = value;
  }

  /**
   * Creates a new Customer RecordBuilder.
   * @return A new Customer RecordBuilder
   */
  public static com.snow.schema.Customer.Builder newBuilder() {
    return new com.snow.schema.Customer.Builder();
  }

  /**
   * Creates a new Customer RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Customer RecordBuilder
   */
  public static com.snow.schema.Customer.Builder newBuilder(com.snow.schema.Customer.Builder other) {
    if (other == null) {
      return new com.snow.schema.Customer.Builder();
    } else {
      return new com.snow.schema.Customer.Builder(other);
    }
  }

  /**
   * Creates a new Customer RecordBuilder by copying an existing Customer instance.
   * @param other The existing instance to copy.
   * @return A new Customer RecordBuilder
   */
  public static com.snow.schema.Customer.Builder newBuilder(com.snow.schema.Customer other) {
    if (other == null) {
      return new com.snow.schema.Customer.Builder();
    } else {
      return new com.snow.schema.Customer.Builder(other);
    }
  }

  /**
   * RecordBuilder for Customer instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Customer>
    implements org.apache.avro.data.RecordBuilder<Customer> {

    private int customerid;
    private int customeramount;
    private java.lang.CharSequence customername;
    private java.lang.CharSequence paymenttype;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.snow.schema.Customer.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.customerid)) {
        this.customerid = data().deepCopy(fields()[0].schema(), other.customerid);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.customeramount)) {
        this.customeramount = data().deepCopy(fields()[1].schema(), other.customeramount);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.customername)) {
        this.customername = data().deepCopy(fields()[2].schema(), other.customername);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.paymenttype)) {
        this.paymenttype = data().deepCopy(fields()[3].schema(), other.paymenttype);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing Customer instance
     * @param other The existing instance to copy.
     */
    private Builder(com.snow.schema.Customer other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.customerid)) {
        this.customerid = data().deepCopy(fields()[0].schema(), other.customerid);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.customeramount)) {
        this.customeramount = data().deepCopy(fields()[1].schema(), other.customeramount);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.customername)) {
        this.customername = data().deepCopy(fields()[2].schema(), other.customername);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.paymenttype)) {
        this.paymenttype = data().deepCopy(fields()[3].schema(), other.paymenttype);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'customerid' field.
      * @return The value.
      */
    public int getCustomerid() {
      return customerid;
    }


    /**
      * Sets the value of the 'customerid' field.
      * @param value The value of 'customerid'.
      * @return This builder.
      */
    public com.snow.schema.Customer.Builder setCustomerid(int value) {
      validate(fields()[0], value);
      this.customerid = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'customerid' field has been set.
      * @return True if the 'customerid' field has been set, false otherwise.
      */
    public boolean hasCustomerid() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'customerid' field.
      * @return This builder.
      */
    public com.snow.schema.Customer.Builder clearCustomerid() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'customeramount' field.
      * @return The value.
      */
    public int getCustomeramount() {
      return customeramount;
    }


    /**
      * Sets the value of the 'customeramount' field.
      * @param value The value of 'customeramount'.
      * @return This builder.
      */
    public com.snow.schema.Customer.Builder setCustomeramount(int value) {
      validate(fields()[1], value);
      this.customeramount = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'customeramount' field has been set.
      * @return True if the 'customeramount' field has been set, false otherwise.
      */
    public boolean hasCustomeramount() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'customeramount' field.
      * @return This builder.
      */
    public com.snow.schema.Customer.Builder clearCustomeramount() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'customername' field.
      * @return The value.
      */
    public java.lang.CharSequence getCustomername() {
      return customername;
    }


    /**
      * Sets the value of the 'customername' field.
      * @param value The value of 'customername'.
      * @return This builder.
      */
    public com.snow.schema.Customer.Builder setCustomername(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.customername = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'customername' field has been set.
      * @return True if the 'customername' field has been set, false otherwise.
      */
    public boolean hasCustomername() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'customername' field.
      * @return This builder.
      */
    public com.snow.schema.Customer.Builder clearCustomername() {
      customername = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'paymenttype' field.
      * @return The value.
      */
    public java.lang.CharSequence getPaymenttype() {
      return paymenttype;
    }


    /**
      * Sets the value of the 'paymenttype' field.
      * @param value The value of 'paymenttype'.
      * @return This builder.
      */
    public com.snow.schema.Customer.Builder setPaymenttype(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.paymenttype = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'paymenttype' field has been set.
      * @return True if the 'paymenttype' field has been set, false otherwise.
      */
    public boolean hasPaymenttype() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'paymenttype' field.
      * @return This builder.
      */
    public com.snow.schema.Customer.Builder clearPaymenttype() {
      paymenttype = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Customer build() {
      try {
        Customer record = new Customer();
        record.customerid = fieldSetFlags()[0] ? this.customerid : (java.lang.Integer) defaultValue(fields()[0]);
        record.customeramount = fieldSetFlags()[1] ? this.customeramount : (java.lang.Integer) defaultValue(fields()[1]);
        record.customername = fieldSetFlags()[2] ? this.customername : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.paymenttype = fieldSetFlags()[3] ? this.paymenttype : (java.lang.CharSequence) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Customer>
    WRITER$ = (org.apache.avro.io.DatumWriter<Customer>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Customer>
    READER$ = (org.apache.avro.io.DatumReader<Customer>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeInt(this.customerid);

    out.writeInt(this.customeramount);

    out.writeString(this.customername);

    out.writeString(this.paymenttype);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.customerid = in.readInt();

      this.customeramount = in.readInt();

      this.customername = in.readString(this.customername instanceof Utf8 ? (Utf8)this.customername : null);

      this.paymenttype = in.readString(this.paymenttype instanceof Utf8 ? (Utf8)this.paymenttype : null);

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.customerid = in.readInt();
          break;

        case 1:
          this.customeramount = in.readInt();
          break;

        case 2:
          this.customername = in.readString(this.customername instanceof Utf8 ? (Utf8)this.customername : null);
          break;

        case 3:
          this.paymenttype = in.readString(this.paymenttype instanceof Utf8 ? (Utf8)this.paymenttype : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










