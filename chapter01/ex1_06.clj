;; At this very case, it is expected a stack overflow, because
;; both, then-clause and else-clause, are evaluated on new-if call, since
;; Clojure uses an applicative-order, consequently the recursive call on
;; else-clause will never reach the stop condition.


(defn abs [x]
  (if (< x 0) (- x) x))

(defn square [x]
  (* x x))

(defn average [x y]
  (/ (+ x y) 2))

(defn good-enough? [guess x]
  (< (abs (- (square guess) x)) 0.001))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn new-if [predicate then-clause else-clause]
  (cond predicate then-clause
        :else else-clause))

(defn sqrt-iter [guess x]
  (new-if (good-enough? guess x)
          guess
          (sqrt-iter (improve guess x) x)))

(defn sqrt-iter-if [guess x]
  (if (good-enough? guess x)
      guess
      (sqrt-iter-if (improve guess x) x)))

(defn sqrt [x] (sqrt-iter 1.0 x))

(defn sqrt-if [x] (sqrt-iter-if 1.0 x))

(let [[_ str-n method] *command-line-args*
      n (read-string str-n)]
  (if (= method "if")
      (println (sqrt-if n))
      ;; => stack overflow
      (println (sqrt n))))
