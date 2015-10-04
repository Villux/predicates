(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))


(defn equal-to [n]
  (fn [k] (== k n)))


(defn set->predicate [a-set]
  (fn [a-key] (contains? a-set a-key)))


(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))


(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))


(defn has-award? [book award]
  (contains? (:awards book) award))


;; This was my first solution for this, but it has unneeded steps
;; (every? true? (map #(has-award? book %))
(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [ filtered-list (filter identity (map pred a-seq))]
    (if (empty? filtered-list)
      false
      (first filtered-list))))


(defn my-every? [pred a-seq]
  (every? true? (map pred a-seq)))

(defn prime? [n]
  (let [pred (fn [int] (= 0 (mod n int)))]
    (not (some pred (range 2 n)))))

