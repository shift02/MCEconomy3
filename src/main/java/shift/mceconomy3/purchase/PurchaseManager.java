package shift.mceconomy3.purchase;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;

import net.minecraftforge.fml.common.discovery.ASMDataTable;
import shift.mceconomy3.api.purchase.IPurchaseRegistry;
import shift.mceconomy3.api.purchase.PurchaseItems;

public class PurchaseManager {

    public static PurchaseRegistry purchaseRegistry = new PurchaseRegistry();
    public static List<Object> purchaseItems;

    private PurchaseManager() {

    }

    public static void registryPurchaseItems() {

        for (Object ob : purchaseItems) {

            Method[] ms = ob.getClass().getDeclaredMethods();

            for (Method m : ms) {

                if (isEventHandler(m)) {

                    try {

                        m.invoke(ob, new Object[] { (IPurchaseRegistry) purchaseRegistry });

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }

            }

        }

    }

    private static boolean isEventHandler(Method m) {

        for (Annotation annotation : m.getAnnotations()) {

            if (annotation.annotationType().equals(PurchaseItems.EventHandler.class)) {

                Class<? extends Object> methodArgs[] = m.getParameterTypes();
                if (methodArgs.length != 1) continue;
                if (methodArgs[0].toString().matches(".*" + "IPurchaseRegistry" + ".*")) {
                    return true;
                }

            }

        }

        return false;

    }

    public static void setPurchaseItems(@Nonnull ASMDataTable asmDataTable) {

        purchaseItems = getPurchaseItems(asmDataTable);

    }

    public static List<Object> getPurchaseItems(@Nonnull ASMDataTable asmDataTable) {
        return getInstances(asmDataTable, PurchaseItems.class);
    }

    private static List<Object> getInstances(@Nonnull ASMDataTable asmDataTable, Class annotationClass) {

        String annotationClassName = annotationClass.getCanonicalName();
        Set<ASMDataTable.ASMData> asmDatas = asmDataTable.getAll(annotationClassName);

        List<Object> instances = new ArrayList<Object>();
        for (ASMDataTable.ASMData asmData : asmDatas) {

            try {
                Class<?> asmClass = Class.forName(asmData.getClassName());
                Object instance = asmClass.newInstance();
                instances.add(instance);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return instances;

    }

}
