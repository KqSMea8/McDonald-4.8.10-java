package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzsg extends IInterface {

    public static abstract class zza extends Binder implements zzsg {

        private static class zza implements zzsg {
            private IBinder zzpb;

            public IBinder asBinder() {
                return this.zzpb;
            }

            public boolean getBooleanFlagValue(String str, boolean z, int i) throws RemoteException {
                boolean z2 = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    this.zzpb.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getIntFlagValue(String str, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.zzpb.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long getLongFlagValue(String str, long j, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    this.zzpb.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    long readLong = obtain2.readLong();
                    return readLong;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getStringFlagValue(String str, String str2, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeInt(i);
                    this.zzpb.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void init(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.flags.IFlagProvider");
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
            attachInterface(this, "com.google.android.gms.flags.IFlagProvider");
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            int i3 = 0;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    init(com.google.android.gms.dynamic.zzd.zza.zzbz(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    boolean booleanFlagValue = getBooleanFlagValue(parcel.readString(), parcel.readInt() != 0, parcel.readInt());
                    parcel2.writeNoException();
                    if (booleanFlagValue) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    int intFlagValue = getIntFlagValue(parcel.readString(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(intFlagValue);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    long longFlagValue = getLongFlagValue(parcel.readString(), parcel.readLong(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeLong(longFlagValue);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.flags.IFlagProvider");
                    String stringFlagValue = getStringFlagValue(parcel.readString(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeString(stringFlagValue);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.flags.IFlagProvider");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean getBooleanFlagValue(String str, boolean z, int i) throws RemoteException;

    int getIntFlagValue(String str, int i, int i2) throws RemoteException;

    long getLongFlagValue(String str, long j, int i) throws RemoteException;

    String getStringFlagValue(String str, String str2, int i) throws RemoteException;

    void init(zzd zzd) throws RemoteException;
}
