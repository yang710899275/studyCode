/*
package sheji.cglib;

import org.springframework.asm.Type;
import org.springframework.cglib.core.KeyFactory;
import org.springframework.cglib.core.WeakCacheKey;
import org.springframework.cglib.proxy.Enhancer;

public class Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$4ce19e8f extends KeyFactory implements Enhancer.EnhancerKey {
    private final String FIELD_0;
    private final String[] FIELD_1;
    private final WeakCacheKey FIELD_2;
    private final Type[] FIELD_3;
    private final boolean FIELD_4;
    private final boolean FIELD_5;
    private final Long FIELD_6;

    public Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$4ce19e8f() {
    }

    public Object newInstance(String var1, String[] var2, WeakCacheKey var3, Type[] var4, boolean var5, boolean var6, Long var7) {
        return new Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$4ce19e8f(var1, var2, var3, var4, var5, var6, var7);
    }

    public Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$4ce19e8f(String var1, String[] var2, WeakCacheKey var3, Type[] var4, boolean var5, boolean var6, Long var7) {
        this.FIELD_0 = var1;
        this.FIELD_1 = var2;
        this.FIELD_2 = var3;
        this.FIELD_3 = var4;
        this.FIELD_4 = var5;
        this.FIELD_5 = var6;
        this.FIELD_6 = var7;
    }

    public int hashCode() {
        int var10002 = 1213 * 1209107;
        String var10001 = this.FIELD_0;
        int var10000 = var10002 + (var10001 != null ? var10001.hashCode() : 0);
        String[] var5 = this.FIELD_1;
        if (var5 != null) {
            String[] var1 = var5;

            for(int var2 = 0; var2 < var1.length; ++var2) {
                var10000 = var10000 * 1209107 + (var1[var2] != null ? var1[var2].hashCode() : 0);
            }
        }

        var10002 = var10000 * 1209107;
        WeakCacheKey var6 = this.FIELD_2;
        var10000 = var10002 + (var6 != null ? var6.hashCode() : 0);
        Type[] var7 = this.FIELD_3;
        if (var7 != null) {
            Type[] var3 = var7;

            for(int var4 = 0; var4 < var3.length; ++var4) {
                var10000 = var10000 * 1209107 + (var3[var4] != null ? var3[var4].hashCode() : 0);
            }
        }

        var10002 = ((var10000 * 1209107 + (this.FIELD_4 ^ 1)) * 1209107 + (this.FIELD_5 ^ 1)) * 1209107;
        Long var8 = this.FIELD_6;
        return var10002 + (var8 != null ? var8.hashCode() : 0);
    }

    public boolean equals(Object var1) {
        if (var1 instanceof Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$4ce19e8f) {
            String var10000 = this.FIELD_0;
            String var10001 = ((Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$4ce19e8f)var1).FIELD_0;
            if (var10001 == null) {
                if (var10000 != null) {
                    return false;
                }
            } else if (var10000 == null || !var10000.equals(var10001)) {
                return false;
            }

            String[] var8 = this.FIELD_1;
            String[] var10 = ((Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$4ce19e8f)var1).FIELD_1;
            if (var10 == null) {
                if (var8 != null) {
                    return false;
                }
            } else {
                label178: {
                    if (var8 != null) {
                        if (var10.length == var8.length) {
                            String[] var2 = var10;
                            String[] var3 = var8;
                            int var4 = 0;

                            while(true) {
                                if (var4 >= var2.length) {
                                    break label178;
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

            WeakCacheKey var9 = this.FIELD_2;
            WeakCacheKey var13 = ((Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$4ce19e8f)var1).FIELD_2;
            if (var13 == null) {
                if (var9 != null) {
                    return false;
                }
            } else if (var9 == null || !var9.equals(var13)) {
                return false;
            }

            Type[] var11 = this.FIELD_3;
            Type[] var15 = ((Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$4ce19e8f)var1).FIELD_3;
            if (var15 == null) {
                if (var11 != null) {
                    return false;
                }
            } else {
                if (var11 == null) {
                    return false;
                }

                if (var15.length != var11.length) {
                    return false;
                }

                Type[] var5 = var15;
                Type[] var6 = var11;

                for(int var7 = 0; var7 < var5.length; ++var7) {
                    Type var12 = var5[var7];
                    Type var16 = var6[var7];
                    if (var6[var7] == null) {
                        if (var12 != null) {
                            return false;
                        }
                    } else if (var12 == null || !var12.equals(var16)) {
                        return false;
                    }
                }
            }

            if (this.FIELD_4 == ((Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$4ce19e8f)var1).FIELD_4 && this.FIELD_5 == ((Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$4ce19e8f)var1).FIELD_5) {
                Long var14 = this.FIELD_6;
                Long var17 = ((Enhancer$EnhancerKey$$KeyFactoryByCGLIB$$4ce19e8f)var1).FIELD_6;
                if (var17 == null) {
                    if (var14 == null) {
                        return true;
                    }
                } else if (var14 != null && var14.equals(var17)) {
                    return true;
                }
            }
        }

        return false;
    }

    public String toString() {
        StringBuffer var10000 = new StringBuffer();
        String var10001 = this.FIELD_0;
        var10000 = (var10001 != null ? var10000.append(var10001.toString()) : var10000.append("null")).append(", ");
        String[] var6 = this.FIELD_1;
        if (var6 != null) {
            var10000 = var10000.append("{");
            String[] var1 = var6;

            for(int var2 = 0; var2 < var1.length; ++var2) {
                var10000 = (var1[var2] != null ? var10000.append(var1[var2].toString()) : var10000.append("null")).append(", ");
            }

            var10000.setLength(var10000.length() - 2);
            var10000 = var10000.append("}");
        } else {
            var10000 = var10000.append("null");
        }

        var10000 = var10000.append(", ");
        WeakCacheKey var9 = this.FIELD_2;
        var10000 = (var9 != null ? var10000.append(var9.toString()) : var10000.append("null")).append(", ");
        Type[] var10 = this.FIELD_3;
        if (var10 != null) {
            var10000 = var10000.append("{");
            Type[] var3 = var10;

            for(int var4 = 0; var4 < var3.length; ++var4) {
                var10000 = (var3[var4] != null ? var10000.append(var3[var4].toString()) : var10000.append("null")).append(", ");
            }

            var10000.setLength(var10000.length() - 2);
            var10000 = var10000.append("}");
        } else {
            var10000 = var10000.append("null");
        }

        var10000 = var10000.append(", ").append(this.FIELD_4).append(", ").append(this.FIELD_5).append(", ");
        Long var13 = this.FIELD_6;
        return (var13 != null ? var10000.append(var13.toString()) : var10000.append("null")).toString();
    }
}
*/
