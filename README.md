# Kryptowährungs-Datenaggregation und -sortierung

## Übersicht

Dieses Repository enthält eine Java-Implementierung zur Aggregation und Sortierung von Kryptowährungsdaten. Das Projekt ist so strukturiert, dass Kryptowährungen nach ihrer Blockchain gruppiert und nach ihrer täglichen Mining-Menge in absteigender Reihenfolge sortiert werden. Die implementierte Lösung nutzt den Merge-Sort-Algorithmus für die Sortierung, um eine effiziente Handhabung großer Datensätze zu gewährleisten.

## Projektstruktur

Das Projekt besteht aus den folgenden Hauptkomponenten:

- **Row-Klasse**: Repräsentiert einzelne Datensätze von Kryptowährungen.
- **AggregatedRow-Klasse**: Repräsentiert aggregierte Datensätze, die nach Blockchain gruppiert sind.
- **Aggregator-Klasse**: Verantwortlich für die Aggregation der Rohdaten in aggregierte Einträge.
- **Sorter-Klasse**: Implementiert den Merge-Sort-Algorithmus, um die aggregierten Daten zu sortieren.
- **Main-Klasse**: Bietet ein Beispiel zur Demonstration der Funktionalität des Aggregations- und Sortierungsprozesses.


