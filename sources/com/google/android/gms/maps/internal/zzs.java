package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzs extends IInterface {

    public static abstract class zza extends Binder implements zzs {

        private static class zza implements zzs {
            private IBinder zzpb;

            zza(IBinder iBinder) {
                this.zzpb = iBinder;
            }

            public IBinder asBinder() {
                return this.zzpb;
            }

            public void zzy(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzpb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
        }

        public static zzs zzcW(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzs)) ? new zza(iBinder) : (zzs) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
                    zzy(com.google.android.gms.dynamic.zzd.zza.zzbz(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnMyLocationChangeListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zzy(zzd zzd) throws RemoteException;
}
