(defn abs [x]
  (if (< x 0) (- x) x))

(defn square [x]
  (* x x))

(defn average [x y]
  (/ (+ x y) 2))

(defn good-enough? [last-guess guess]
  (< (abs (/ (- last-guess guess) last-guess)) 0.001))

(defn improve [guess x]
  (/ (+
        (* 2 guess)
        (/ x (square guess)))
     3))

(defn cubert-iter [last-guess guess x]
  (if (good-enough? last-guess guess)
      guess
      (cubert-iter guess (improve guess x) x)))

(defn cubert [x] (cubert-iter 0.5 1.0 x))

(let [[_ str-n] *command-line-args*
      n (read-string str-n)]
  (println (cubert n)))
