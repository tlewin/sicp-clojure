(defn- sum-squares [a b]
  (+ (* a a)
     (* b b)))

(defn f [a b c]
  (apply sum-squares
         (cond (and (>= a c) (>= b c)) [a b]
               (and (>= a b) (>= c b)) [a c]
               :else [b c])))

(def test-set [[1 2 3 13] ; a b c expected
               [1 3 2 13]
               [2 1 3 13]
               [2 3 1 13]
               [3 1 2 13]
               [3 2 1 13]
               [2 1 1  5]
               [1 2 1  5]
               [1 1 2  5]
               [1 1 1  2]])

(loop [[h & t] test-set]
  (if-let [[a b c e] h]
    (do
      (-> "f for a: %d b: %d c: %d == %d -- expected: %d"
          (format a b c (f a b c) e)
          (println))
      (recur t))))
