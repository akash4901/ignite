package com.data;


import com.util.IPv4Util;
import java.io.Serializable;

public class IpV4Range implements Serializable {


  private static final long serialVersionUID = -5455204938255543573L;
  private final int ipStart;

  private final int ipEnd;

  public IpV4Range(int ipStart, int ipEnd) {
    this.ipStart = ipStart;
    this.ipEnd = ipEnd;
  }

  public int getIpStart() {
    return ipStart;
  }

  public int getIpEnd() {
    return ipEnd;
  }


  @Override
  public String toString() {
    return "IpV4Range{" + "ipStart=" + IPv4Util.intToIp(ipStart) + ", ipEnd=" + IPv4Util.intToIp(ipEnd) + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    IpV4Range ipV4Range = (IpV4Range) o;

    if (ipStart != ipV4Range.ipStart) {
      return false;
    }
    return ipEnd == ipV4Range.ipEnd;
  }

  @Override
  public int hashCode() {
    int result = (int) (ipStart ^ (ipStart >>> 32));
    result = 31 * result + (int) (ipEnd ^ (ipEnd >>> 32));
    return result;
  }
}
