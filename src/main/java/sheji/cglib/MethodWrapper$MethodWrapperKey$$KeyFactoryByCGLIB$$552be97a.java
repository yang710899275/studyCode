/*
package sheji.cglib;

import org.springframework.cglib.core.KeyFactory;
import org.springframework.cglib.core.MethodWrapper;

public class MethodWrapper$MethodWrapperKey$$KeyFactoryByCGLIB$$552be97a extends KeyFactory implements MethodWrapper.MethodWrapperKey {
    private final String FIELD_0;
    private final String[] FIELD_1;
    private final String FIELD_2;

    public MethodWrapper$MethodWrapperKey$$KeyFactoryByCGLIB$$552be97a() {
    }

    public Object newInstance(String var1, String[] var2, String var3) {
        return new MethodWrapper$MethodWrapperKey$$KeyFactoryByCGLIB$$552be97a(var1, var2, var3);
    }

    public MethodWrapper$MethodWrapperKey$$KeyFactoryByCGLIB$$552be97a(String var1, String[] var2, String var3) {
        this.FIELD_0 = var1;
        this.FIELD_1 = var2;
        this.FIELD_2 = var3;
    }

    public int hashCode() {
        int var10002 = 938313161 * 362693231;
        String var10001 = this.FIELD_0;
        int var10000 = var10002 + (var10001 != null ? var10001.hashCode() : 0);
        String[] var3 = this.FIELD_1;
        if (var3 != null) {
            String[] var1 = var3;

            for(int var2 = 0; var2 < var1.length; ++var2) {
                var10000 = var10000 * 362693231 + (var1[var2] != null ? var1[var2].hashCode() : 0);
            }
        }

        var10002 = var10000 * 362693231;
        var10001 = this.FIELD_2;
        return var10002 + (var10001 != null ? var10001.hashCode() : 0);
    }

    public boolean equals(Object var1) {
        if (var1 instanceof MethodWrapper$MethodWrapperKey$$KeyFactoryByCGLIB$$552be97a) {
            String var10000 = this.FIELD_0;
            String var10001 = ((MethodWrapper$MethodWrapperKey$$KeyFactoryByCGLIB$$552be97a)var1).FIELD_0;
            if (var10001 == null) {
                if (var10000 != null) {
                    return false;
                }
            } else if (var10000 == null || !var10000.equals(var10001)) {
                return false;
            }

            String[] var5 = this.FIELD_1;
            String[] var6 = ((MethodWrapper$MethodWrapperKey$$KeyFactoryByCGLIB$$552be97a)var1).FIELD_1;
            if (var6 == null) {
                if (var5 != null) {
                    return false;
                }
            } else {
                label104: {
                    if (var5 != null) {
                        if (var6.length == var5.length) {
                            String[] var2 = var6;
                            String[] var3 = var5;
                            int var4 = 0;

                            while(true) {
                                if (var4 >= var2.length) {
                                    break label104;
                                }

                                var10000 = var2[var4];
                                var10001 = var3[var4];
                                if (var3[var4] == null) {
                                    if (var10000 != null) {
                                        return false;
                                    }
                                } else if (var10000 == null || !var10000.equals(var10001)) {
                                    return false;
                                }

                                ++var4;
                            }
                        }
                    }

                    return false;
                }
            }

            var10000 = this.FIELD_2;
            var10001 = ((MethodWrapper$MethodWrapperKey$$KeyFactoryByCGLIB$$552be97a)var1).FIELD_2;
            if (var10001 == null) {
                if (var10000 == null) {
                    return true;
                }
            } else if (var10000 != null && var10000.equals(var10001)) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        StringBuffer var10000 = new StringBuffer();
        String var10001 = this.FIELD_0;
        var10000 = (var10001 != null ? var10000.append(var10001.toString()) : var10000.append("null")).append(", ");
        String[] var4 = this.FIELD_1;
        if (var4 != null) {
            var10000 = var10000.append("{");
            String[] var1 = var4;

            for(int var2 = 0; var2 < var1.length; ++var2) {
                var10000 = (var1[var2] != null ? var10000.append(var1[var2].toString()) : var10000.append("null")).append(", ");
            }

            var10000.setLength(var10000.length() - 2);
            var10000 = var10000.append("}");
        } else {
            var10000 = var10000.append("null");
        }

        var10000 = var10000.append(", ");
        var10001 = this.FIELD_2;
        return (var10001 != null ? var10000.append(var10001.toString()) : var10000.append("null")).toString();
    }
}
*/
