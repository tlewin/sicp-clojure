;; For very small numbers the `good-enough?` implementation will not be very
;; effective because if the tested number is less than the threshold (0.001)
;; the iteration will stop before reach a good approximation for the squater
;; root.
;;
;; For very large numbers we have problems with floating point arithmetics
;; precision, specially when square the guess, in order to compare to x.
;;
;; Implementing the `good-enough?` based on relative guess improvement,
;; enable to us to work with very small x, even if it is less than threshold,
;; once we doesn't define the criteria in terms of x.
;; For very large numbers, we are not working with a squared version of the guess,
;; thus we are not propagating the error.

(defn abs [x]
  (if (< x 0) (- x) x))

(defn square [x]
  (* x x))

(defn average [x y]
  (/ (+ x y) 2))

;; Old implementation
;; (defn good-enough? [guess x]
;;   (< (abs (- (square guess) x)) 0.001))

(defn good-enough? [previous-guess guess]
  (< (abs (/ (- previous-guess guess) previous-guess)) 0.001))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn sqrt-iter [previous-guess guess x]
  (if (good-enough? previous-guess guess)
      guess
      (sqrt-iter guess (improve guess x) x)))

(defn sqrt [x] (sqrt-iter 0.5 1.0 x))

(let [[_ str-n] *command-line-args*
      n (read-string str-n)]
  (println (sqrt n)))
