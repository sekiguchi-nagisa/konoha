package konoha.api;

import java.util.Comparator;

import konoha.Coercion;
import konoha.Conversion;
import konoha.Method;
import konoha.script.Lang;
import konoha.script.ScriptRuntimeException;

public class ObjectOp {

	private static String c(Object o) {
		return Lang.name(o.getClass());
	}

	@Method
	public final static Object negate(Object a) {
		if (a instanceof Number) {
			if (a instanceof Double || a instanceof Float) {
				return -((Number) a).doubleValue();
			}
			if (a instanceof Long) {
				return -((Number) a).longValue();
			}
			return -((Number) a).intValue();
		}
		throw new ScriptRuntimeException("NoSuchMethod -%s", c(a));
	}

	@Method
	public final static Object add(Object a, Object b) {
		if (a instanceof Number && b instanceof Number) {
			if (a instanceof Double || a instanceof Double || a instanceof Float || b instanceof Float) {
				return ((Number) a).doubleValue() + ((Number) b).doubleValue();
			}
			if (a instanceof Long || a instanceof Long) {
				return ((Number) a).longValue() + ((Number) b).longValue();
			}
			return ((Number) a).intValue() + ((Number) b).intValue();
		}
		if (a instanceof String) {
			return ((String) a) + b;
		}
		throw new ScriptRuntimeException("unsupproted operation %s + %s", c(a), c(b));
	}

	@Method
	public final static Object subtract(Object a, Object b) {
		if (a instanceof Number && b instanceof Number) {
			if (a instanceof Double || a instanceof Double || a instanceof Float || b instanceof Float) {
				return ((Number) a).doubleValue() - ((Number) b).doubleValue();
			}
			if (a instanceof Long || a instanceof Long) {
				return ((Number) a).longValue() - ((Number) b).longValue();
			}
			return ((Number) a).intValue() - ((Number) b).intValue();
		}
		throw new ScriptRuntimeException("unsupproted operation %s - %s", c(a), c(b));
	}

	@Method
	public final static Object multiply(Object a, Object b) {
		if (a instanceof Number && b instanceof Number) {
			if (a instanceof Double || a instanceof Double || a instanceof Float || b instanceof Float) {
				return ((Number) a).doubleValue() * ((Number) b).doubleValue();
			}
			if (a instanceof Long || a instanceof Long) {
				return ((Number) a).longValue() * ((Number) b).longValue();
			}
			return ((Number) a).intValue() * ((Number) b).intValue();
		}
		throw new ScriptRuntimeException("unsupproted operation %s * %s", c(a), c(b));
	}

	@Method
	public final static Object divide(Object a, Object b) {
		if (a instanceof Number && b instanceof Number) {
			if (a instanceof Double || a instanceof Double || a instanceof Float || b instanceof Float) {
				return ((Number) a).doubleValue() / ((Number) b).doubleValue();
			}
			if (a instanceof Long || a instanceof Long) {
				return ((Number) a).longValue() / ((Number) b).longValue();
			}
			return ((Number) a).intValue() / ((Number) b).intValue();
		}
		throw new ScriptRuntimeException("unsupproted operation %s / %s", c(a), c(b));
	}

	@Method
	public final static Object mod(Object a, Object b) {
		if (a instanceof Number && b instanceof Number) {
			if (a instanceof Double || a instanceof Double || a instanceof Float || b instanceof Float) {
				return ((Number) a).doubleValue() % ((Number) b).doubleValue();
			}
			if (a instanceof Long || a instanceof Long) {
				return ((Number) a).longValue() % ((Number) b).longValue();
			}
			return ((Number) a).intValue() % ((Number) b).intValue();
		}
		throw new ScriptRuntimeException("unsupproted operation %s % %s", c(a), c(b));
	}

	@Method
	@SuppressWarnings("unchecked")
	public final static int compareTo(Object a, Object b) {
		if (a instanceof Comparator<?> && a.getClass() == b.getClass()) {
			return ((Comparator<Object>) a).compare(a, b);
		}
		return a == b ? 0 : -1;
	}

	@Method
	@SuppressWarnings("unchecked")
	public final static boolean eq(Object a, Object b) {
		if (a instanceof Number && b instanceof Number) {
			if (a instanceof Double || a instanceof Double || a instanceof Float || b instanceof Float) {
				return ((Number) a).doubleValue() == ((Number) b).doubleValue();
			}
			if (a instanceof Long || a instanceof Long) {
				return ((Number) a).longValue() == ((Number) b).longValue();
			}
			return ((Number) a).intValue() == ((Number) b).intValue();
		}
		if (a instanceof Comparator<?> && a.getClass() == b.getClass()) {
			return ((Comparator<Object>) a).compare(a, b) == 0;
		}
		return a == b;
	}

	@Method
	@SuppressWarnings("unchecked")
	public final static boolean ne(Object a, Object b) {
		if (a instanceof Number && b instanceof Number) {
			if (a instanceof Double || a instanceof Double || a instanceof Float || b instanceof Float) {
				return ((Number) a).doubleValue() != ((Number) b).doubleValue();
			}
			if (a instanceof Long || a instanceof Long) {
				return ((Number) a).longValue() != ((Number) b).longValue();
			}
			return ((Number) a).intValue() != ((Number) b).intValue();
		}
		if (a instanceof Comparator<?> && a.getClass() == b.getClass()) {
			return ((Comparator<Object>) a).compare(a, b) == 0;
		}
		return a != b;
	}

	@Method
	@SuppressWarnings("unchecked")
	public final static boolean lt(Object a, Object b) {
		if (a instanceof Number && b instanceof Number) {
			if (a instanceof Double || a instanceof Double || a instanceof Float || b instanceof Float) {
				return ((Number) a).doubleValue() < ((Number) b).doubleValue();
			}
			if (a instanceof Long || a instanceof Long) {
				return ((Number) a).longValue() < ((Number) b).longValue();
			}
			return ((Number) a).intValue() < ((Number) b).intValue();
		}
		if (a instanceof Comparator<?> && a.getClass() == b.getClass()) {
			return ((Comparator<Object>) a).compare(a, b) < 0;
		}
		throw new ScriptRuntimeException("unsupproted operation %s < %s", c(a), c(b));
	}

	@Method
	@SuppressWarnings("unchecked")
	public final static boolean gt(Object a, Object b) {
		if (a instanceof Number && b instanceof Number) {
			if (a instanceof Double || a instanceof Double || a instanceof Float || b instanceof Float) {
				return ((Number) a).doubleValue() > ((Number) b).doubleValue();
			}
			if (a instanceof Long || a instanceof Long) {
				return ((Number) a).longValue() > ((Number) b).longValue();
			}
			return ((Number) a).intValue() > ((Number) b).intValue();
		}
		if (a instanceof Comparator<?> && a.getClass() == b.getClass()) {
			return ((Comparator<Object>) a).compare(a, b) > 0;
		}
		throw new ScriptRuntimeException("unsupproted operation %s > %s", c(a), c(b));
	}

	@Method
	@SuppressWarnings("unchecked")
	public final static boolean lte(Object a, Object b) {
		if (a instanceof Number && b instanceof Number) {
			if (a instanceof Double || a instanceof Double || a instanceof Float || b instanceof Float) {
				return ((Number) a).doubleValue() <= ((Number) b).doubleValue();
			}
			if (a instanceof Long || a instanceof Long) {
				return ((Number) a).longValue() <= ((Number) b).longValue();
			}
			return ((Number) a).intValue() <= ((Number) b).intValue();
		}
		if (a instanceof Comparator<?> && a.getClass() == b.getClass()) {
			return ((Comparator<Object>) a).compare(a, b) <= 0;
		}
		throw new ScriptRuntimeException("unsupproted operation %s <= %s", c(a), c(b));
	}

	@Method
	@SuppressWarnings("unchecked")
	public final static boolean gte(Object a, Object b) {
		if (a instanceof Number && b instanceof Number) {
			if (a instanceof Double || a instanceof Double || a instanceof Float || b instanceof Float) {
				return ((Number) a).doubleValue() >= ((Number) b).doubleValue();
			}
			if (a instanceof Long || a instanceof Long) {
				return ((Number) a).longValue() >= ((Number) b).longValue();
			}
			return ((Number) a).intValue() >= ((Number) b).intValue();
		}
		if (a instanceof Comparator<?> && a.getClass() == b.getClass()) {
			return ((Comparator<Object>) a).compare(a, b) >= 0;
		}
		throw new ScriptRuntimeException("unsupproted operation %s >= %s", c(a), c(b));
	}

	@Method
	public final static Object shiftLeft(Object a, Object b) {
		if (a instanceof Number && b instanceof Number) {
			if (a instanceof Long || a instanceof Long) {
				return ((Number) a).longValue() << ((Number) b).longValue();
			}
			return ((Number) a).intValue() << ((Number) b).intValue();
		}
		throw new ScriptRuntimeException("unsupproted operation %s << %s", c(a), c(b));
	}

	@Method
	public final static Object shiftRight(Object a, Object b) {
		if (a instanceof Number && b instanceof Number) {
			if (a instanceof Long || a instanceof Long) {
				return ((Number) a).longValue() >> ((Number) b).longValue();
			}
			return ((Number) a).intValue() >> ((Number) b).intValue();
		}
		throw new ScriptRuntimeException("unsupproted operation %s >> %s", c(a), c(b));
	}

	@Method
	public final static Object and(Object a, Object b) {
		if (a instanceof Number && b instanceof Number) {
			if (a instanceof Long || a instanceof Long) {
				return ((Number) a).longValue() & ((Number) b).longValue();
			}
			return ((Number) a).intValue() & ((Number) b).intValue();
		}
		throw new ScriptRuntimeException("unsupproted operation %s & %s", c(a), c(b));
	}

	@Method
	public final static Object or(Object a, Object b) {
		if (a instanceof Number && b instanceof Number) {
			if (a instanceof Long || a instanceof Long) {
				return ((Number) a).longValue() | ((Number) b).longValue();
			}
			return ((Number) a).intValue() | ((Number) b).intValue();
		}
		throw new ScriptRuntimeException("unsupproted operation %s | %s", c(a), c(b));
	}

	@Method
	public final static Object xor(Object a, Object b) {
		if (a instanceof Number && b instanceof Number) {
			if (a instanceof Long || a instanceof Long) {
				return ((Number) a).longValue() | ((Number) b).longValue();
			}
			return ((Number) a).intValue() | ((Number) b).intValue();
		}
		throw new ScriptRuntimeException("unsupproted operation %s ^ %s", c(a), c(b));
	}

	@Method
	public final static Object not(Object a) {
		if (a instanceof Long) {
			return ~((Number) a).longValue();
		}
		if (a instanceof Number) {
			return ~((Number) a).intValue();
		}
		if (a instanceof Boolean) {
			return !((Boolean) a);
		}
		throw new ScriptRuntimeException("unsupproted operation ~ %s", c(a));
	}

	/** downcast */

	@Coercion
	public final static boolean to_boolean(Object a) {
		return (Boolean) a;
	}

	@Coercion
	public final static byte to_byte(Object a) {
		return ((Number) a).byteValue();
	}

	@Coercion
	public final static short to_short(Object a) {
		return ((Number) a).shortValue();
	}

	@Coercion
	public final static int to_int(Object a) {
		return ((Number) a).intValue();
	}

	@Coercion
	public final static long to_long(Object a) {
		return ((Number) a).longValue();
	}

	@Coercion
	public final static float to_float(Object a) {
		return ((Number) a).floatValue();
	}

	@Coercion
	public final static double to_double(Object a) {
		return ((Number) a).doubleValue();
	}

	@Conversion
	public final static String toString(Object x) {
		return x == null ? "null" : x.toString();
	}

}
